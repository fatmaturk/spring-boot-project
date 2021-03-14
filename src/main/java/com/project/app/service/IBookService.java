package com.project.app.service;

import com.project.app.model.bookDO;

import java.util.List;

public interface IBookService {
    bookDO createBook(bookDO bookInfo);

    bookDO updateBook(bookDO bookInfo);

    bookDO getBook(String bookId);

    List<bookDO> getAllBooks();

    void deleteBook(String oid);
}
