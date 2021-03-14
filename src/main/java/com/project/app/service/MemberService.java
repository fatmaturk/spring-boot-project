package com.project.app.service;

import com.project.app.model.bookDO;
import com.project.app.model.memberDO;
import com.project.app.repository.IMemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService{

    @Autowired
    private IMemberDAO memberDAO;

    @Override
    public memberDO createMember(memberDO memberInfo) {
        return memberDAO.save(memberInfo);
    }

    @Override
    public memberDO updateMember(memberDO memberInfo) {
        String memberId = memberInfo.getOid();
        Optional<memberDO> member = memberDAO.findById(memberId);
        if(member.isPresent()){
            member.get().setName(memberInfo.getName());
            member.get().setSurname(memberInfo.getSurname());
            member.get().setTckn(memberInfo.getTckn());
            member.get().setBanStatus(memberInfo.isBanStatus());
            member.get().setBanDate(memberInfo.getBanDate());
            member.get().setEducationLevelId(memberInfo.getEducationLevelId());
            memberDAO.save(member.get());
            return member.get();
        }else{
            return null;
        }
    }

    @Override
    public memberDO getMember(String oid) {
        Optional<memberDO> member = memberDAO.findById(oid);
        if(member.isPresent()){
            memberDO memberInfo = memberDAO.getOne(oid);
            return memberInfo;
        }else {
            return null;
        }
    }

    @Override
    public List<memberDO> getAllMembers() {
        return memberDAO.findAll();
    }

    @Override
    public void deleteMember(String oid) {
        Optional<memberDO> member = memberDAO.findById(oid);
        if(member.isPresent()){
            memberDAO.deleteById(oid);
        }
    }

}
