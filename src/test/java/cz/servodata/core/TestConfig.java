package cz.servodata.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.servodata.core.domain.Persistent;
import cz.servodata.core.repository.CompanyRepository;
import cz.servodata.core.service.CsvImportService;
import cz.servodata.core.service.DefaultCsvImportService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = CompanyRepository.class)
@EntityScan(basePackageClasses = Persistent.class)
public class TestConfig {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Bean
    public CsvImportService csvImportService() {
        return new DefaultCsvImportService();
    }
}
