package com.project.app.repository;

import com.project.app.model.memberDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberDAO extends JpaRepository<memberDO, String >{

}
