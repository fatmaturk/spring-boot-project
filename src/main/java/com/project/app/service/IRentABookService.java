package com.project.app.service;

import com.project.app.model.leasedBookDO;

import java.text.ParseException;
import java.util.List;

public interface IRentABookService {
    leasedBookDO createRent(leasedBookDO rentInfo) throws ParseException;

    leasedBookDO updateRent(leasedBookDO rentInfo) throws ParseException;

    leasedBookDO getRentInfo(String oid);

    List<leasedBookDO> getAllRents();
}
