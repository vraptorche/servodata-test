package cz.servodata.core.service;

import cz.servodata.core.ImportStats;
import cz.servodata.core.TestConfig;
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
public class DefaultCsvImportServiceTest {
    @Autowired
    private CsvImportService csvImportService;

    @Test
    public void importData() throws Exception {
        ImportStats stats = csvImportService.importData("classpath:servodata.csv");
        assertThat(stats.getInserted()).isEqualTo(2);
        assertThat(stats.getUpdated()).isEqualTo(0);
    }

}