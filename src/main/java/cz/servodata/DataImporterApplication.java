package cz.servodata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataImporterApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DataImporterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
