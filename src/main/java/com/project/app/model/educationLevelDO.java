package com.project.app.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// egitim seviyelerine ait bilgiler

@Data
@Entity
@Table(name = "educationLevel")

public class educationLevelDO {
    @Id
    private String oid;
    private String level;
    private byte periodWeek;
}
