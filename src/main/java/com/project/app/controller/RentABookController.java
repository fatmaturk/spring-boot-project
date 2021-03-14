package com.project.app.controller;

import com.project.app.model.leasedBookDO;
import com.project.app.service.IRentABookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/library/v1")
public class RentABookController {

    private IRentABookService rentABookService;

    @PostMapping(path = "/leasedBook",consumes = "application/json",produces = "application/json")
    public ResponseEntity<leasedBookDO> createRent(@RequestBody leasedBookDO rentInfo) throws ParseException {
        leasedBookDO createdRent = rentABookService.createRent(rentInfo);
        return new ResponseEntity(createdRent, HttpStatus.CREATED);
    }
    @PutMapping(path = "/leasedBook",consumes = "application/json",produces = "application/json")
    public ResponseEntity<leasedBookDO> updateRent(@RequestBody leasedBookDO rentInfo) throws ParseException {
        leasedBookDO updatedRent = rentABookService.updateRent(rentInfo);
        return new ResponseEntity(updatedRent,HttpStatus.CREATED);
    }

    @GetMapping(path = "/leasedBook/{oid}")
    public ResponseEntity<leasedBookDO> getRent(@PathVariable(value = "oid") String oid){
        leasedBookDO rentInfo = rentABookService.getRentInfo(oid);
        return new ResponseEntity(rentInfo,HttpStatus.OK);
    }

    @GetMapping(path = "/leasedBook")
    public ResponseEntity<List<leasedBookDO>> getAllRents(){
        List<leasedBookDO> allRents = rentABookService.getAllRents();
        return new ResponseEntity(allRents,HttpStatus.OK);
    }


}
