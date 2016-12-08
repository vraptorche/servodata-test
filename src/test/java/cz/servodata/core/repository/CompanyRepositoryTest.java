package cz.servodata.core.repository;

import cz.servodata.core.domain.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository repository;

    @Test
    public void save() throws Exception {
        Company result = repository.save(new Company());
        assertThat(result.getUuid()).isNotNull();
    }

    @Test
    public void findByCompanyId() throws Exception {
        repository.findByCompanyId("00000000");

    }
}