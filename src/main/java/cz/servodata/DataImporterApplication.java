package cz.servodata;

import cz.servodata.config.DataImporterConfigProperties;
import cz.servodata.core.ImportStats;
import cz.servodata.core.service.CsvImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DataImporterApplication implements CommandLineRunner{

	@Autowired
	private CsvImportService csvImportService;

	@Autowired
	private DataImporterConfigProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(DataImporterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] files = properties.getFiles();
		if (files == null) {
			System.out.println("Usage: java -jar data-importer.jar --files=\"./servodata_0.csv, ... ./servodata_n.csv\"");
		} else {
			Arrays.stream(files).forEach(f -> {
				ImportStats stats = csvImportService.importData(f);
				System.out.println(stats);
			});
		}
	}
}
