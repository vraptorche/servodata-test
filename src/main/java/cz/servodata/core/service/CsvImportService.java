package cz.servodata.core.service;

import cz.servodata.core.ImportStats;

import java.io.IOException;


public interface CsvImportService {
    ImportStats importData(String filePath);
}
