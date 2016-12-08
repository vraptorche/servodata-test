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

    public String toString() {
        return String.format("Inserted %d rows.\nUpdated %d rows.\n%d errors occurred.",
                this.inserted, this.updated, this.errors);
    }
}
