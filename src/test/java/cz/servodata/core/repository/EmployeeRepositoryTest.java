package cz.servodata.core.repository;

import cz.servodata.core.TestConfig;
import cz.servodata.core.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = TestConfig.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void save() throws Exception {
        Employee result = repository.save(new Employee());
        assertThat(result.getUuid()).isNotNull();
    }


    @Test
    public void findByEmail() throws Exception {
        repository.findByEmail("bogus");
    }
}