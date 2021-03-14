package com.project.app.controller;


import com.project.app.model.memberDO;
import com.project.app.service.IMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/v1")
public class MemberController {


    private IMemberService memberService;

    //uye olusturma islemi
    @PostMapping(path = "/member",consumes = "application/json",produces = "application/json")
    public ResponseEntity<memberDO> createMember(@RequestBody memberDO memberInfo){
        memberDO createdMember = memberService.createMember(memberInfo);
        return new ResponseEntity(createdMember, HttpStatus.CREATED);
    }

    //update islemi
    @PutMapping(path = "/member",consumes = "application/json",produces = "application/json")
    public ResponseEntity<memberDO> updateMember(@RequestBody memberDO memberInfo){
        memberDO updatedMember = memberService.updateMember(memberInfo);
        return new ResponseEntity(updatedMember,HttpStatus.CREATED);
    }

    //tek uye bilgisi
    @GetMapping(path = "/member/{oid}")
    public ResponseEntity<memberDO> getMember(@PathVariable(value = "oid") String oid){
        memberDO memberInfo = memberService.getMember(oid);
        return new ResponseEntity(memberInfo,HttpStatus.OK);
    }

    //tum uye listesi
    @GetMapping(path = "/member")
    public ResponseEntity<List<memberDO>> getAllMembers(){
        List<memberDO> allMembers = memberService.getAllMembers();
        return new ResponseEntity(allMembers,HttpStatus.OK);
    }

    //uye sil islemi
    @DeleteMapping(path = "/member/{oid}")
    public ResponseEntity<String> deleteMember(@PathVariable(value = "oid") String  oid){
        memberService.deleteMember(oid);
        return new ResponseEntity("Başarılı!",HttpStatus.OK);
    }



}
