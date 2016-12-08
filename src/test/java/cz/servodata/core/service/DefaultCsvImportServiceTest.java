package cz.servodata.core.service;

import cz.servodata.core.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class DefaultCsvImportServiceTest {
    @Autowired
    private CsvImportService csvImportService;

    @Test
    public void importData() throws Exception {
        csvImportService.importData("classpath:servodata.csv");
    }

}