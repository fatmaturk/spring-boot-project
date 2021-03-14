package com.project.app.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//kitap modeline ait bilgiler
@Data
@Entity
@Table(name = "member")
public class memberDO {

    @Id
    private String oid;

    private String name;
    private String surname;
    private String tckn;
    private boolean banStatus;
    private String banEndDate;
    private String educationLevelId;
}
