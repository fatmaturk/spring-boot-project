package com.project.app.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class bookDO {
    @Id
    private String oid;

    private String name;
    private String author;
    private String isbd;
    private int page;

}
