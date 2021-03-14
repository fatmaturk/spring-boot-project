package com.project.app.repository;

import com.project.app.model.rentalBookDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRentalBookDAO extends JpaRepository<rentalBookDO, Long> {
    Optional<rentalBookDO> findById(String bookId);
}
