package cz.servodata.core;


import lombok.Data;

import java.io.Serializable;

@Data
public class ImportStats implements Serializable {
    private int inserted;
    private int updated;
    private int errors;

    public void incUpdates() {
        updated++;
    }

    public void incInserts() {
        inserted++;
    }
}
