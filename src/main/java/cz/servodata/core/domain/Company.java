package cz.servodata.core.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@Data
public class Company extends Persistent {
    @Column(length = 16, unique = true)
    private String companyId;
}
