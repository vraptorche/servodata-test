package cz.servodata.core.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import cz.servodata.core.domain.Company;
import cz.servodata.core.domain.Employee;
import org.apache.metamodel.csv.CsvDataContext;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DefaultCsvImportService implements CsvImportService {
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void importData(String filePath) throws IOException {
        File file = ResourceUtils.getFile(filePath);
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
            System.out.println(company);
            Employee employee = mapper.convertValue(map, Employee.class);
            System.out.println(employee);
        });

    }
}
