package cz.servodata.core.service;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by vraptor on 12/7/2016.
 */
public interface CsvImportService {
    void importData(String filePath) throws IOException;
}
