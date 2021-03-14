package com.project.app.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "rentalBook")
public class rentalBookDO {
    @Id
    private String bookId;
    private boolean stockStatus;
}
