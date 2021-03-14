package com.project.app.repository;

import com.project.app.model.educationLevelDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationLevelDAO extends JpaRepository<educationLevelDO, String> {
    educationLevelDO getMemberId(String oid);
}
