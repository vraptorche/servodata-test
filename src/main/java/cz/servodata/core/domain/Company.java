package cz.servodata.core.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "company")
@Data
public class Company extends Persistent {

    @Column(name = "company_id ", length = 16, unique = true)
    private String companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_address")
    private String companyAddress;

    @Column(name = "update")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
}
