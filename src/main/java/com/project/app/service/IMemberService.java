package com.project.app.service;

import com.project.app.model.memberDO;

import java.util.List;

public interface IMemberService {
    memberDO createMember(memberDO memberInfo);

    memberDO updateMember(memberDO memberInfo);

    memberDO getMember(String oid);

    List<memberDO> getAllMembers();

    void deleteMember(String oid);
}
