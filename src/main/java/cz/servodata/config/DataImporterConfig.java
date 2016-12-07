package cz.servodata.config;

import cz.servodata.core.domain.Persistent;
import cz.servodata.core.repository.CompanyRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = Persistent.class)
@EnableJpaRepositories(basePackageClasses = CompanyRepository.class)
public class DataImporterConfig {
}
