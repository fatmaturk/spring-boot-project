package com.project.app.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "leasedBook")
public class leasedBookDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String bookId;
    private String startDate;
    private String endDate;
    private String deliveryDate;
    private String memberId;
}
