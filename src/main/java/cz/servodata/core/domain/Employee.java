package cz.servodata.core.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@Data
public class Employee extends Persistent {
    @Column(length = 128, unique = true)
    private String email;
}
