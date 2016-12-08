package cz.servodata.core.repository;


import cz.servodata.core.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Employee findByEmail(String email);
}
