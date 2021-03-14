package com.project.app.repository;

import com.project.app.model.leasedBookDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRentABookDAO extends JpaRepository<leasedBookDO, String  > {
    Optional<leasedBookDO> findById(Long rentId);
}
