package cz.servodata.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties()
@Data
public class DataImporterConfigProperties {

    private String[] files;
}
