package cz.servodata.core.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import cz.servodata.core.ImportStats;
import cz.servodata.core.domain.Company;
import cz.servodata.core.domain.Employee;
import cz.servodata.core.repository.CompanyRepository;
import cz.servodata.core.repository.EmployeeRepository;
import org.apache.metamodel.csv.CsvDataContext;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DefaultCsvImportService implements CsvImportService {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ImportStats importData(String filePath) {
        ImportStats stats = new ImportStats();
        File file = null;
        try {
            file = ResourceUtils.getFile(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CsvDataContext dataContext = new CsvDataContext(file);
        Schema schema = dataContext.getDefaultSchema();
        Table table = schema.getTable(0);
        List<Object[]> objects = dataContext.query().from(table).selectAll().execute().toObjectArrays();
        objects.forEach(c -> {
            HashMap<String, Object> map = new HashMap<>();
            for (int i = 0; i < c.length; i++) {
                String name = table.getColumn(i).getName();
                map.put(name, c[i]);
            }
            Company company = mapper.convertValue(map, Company.class);
            Company foundCompany = companyRepository.findByCompanyId(company.getCompanyId());
            if (foundCompany != null) {
                BeanUtils.copyProperties(company, foundCompany, "uuid", "version");
                company = foundCompany;
                stats.incUpdates();
            } else {
                stats.incInserts();
            }
            companyRepository.save(company);
            Employee employee = mapper.convertValue(map, Employee.class);
            Employee foundEmployee = employeeRepository.findByEmail(employee.getEmail());
            if (foundEmployee != null) {
                BeanUtils.copyProperties(employee, foundEmployee, "uuid", "version");
                employee = foundEmployee;
                stats.incUpdates();
            } else {
                stats.incInserts();
            }
            employeeRepository.save(employee);
        });
        return stats;
    }
}
