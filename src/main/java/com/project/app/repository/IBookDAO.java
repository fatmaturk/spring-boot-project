package com.project.app.repository;

import com.project.app.model.bookDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBookDAO extends JpaRepository<bookDO, String> {

    Optional<bookDO> findById(String bookId);

    bookDO getOne(String bookId);

    void deleteById(String bookId);
}
