package com.project.app.service;

import com.project.app.model.bookDO;
import com.project.app.repository.IBookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService  implements IBookService {
    @Autowired
    private IBookDAO bookDAO;

    @Override
    public bookDO createBook(bookDO bookInfo) {
        return bookDAO.save(bookInfo);
    }

    @Override
    public bookDO updateBook(bookDO bookInfo) {
        String bookId = bookInfo.getOid();
        Optional<bookDO> book = bookDAO.findById(bookId);
        if(book.isPresent()){
            book.get().setName(bookInfo.getName());
            book.get().setAuthor(bookInfo.getAuthor());
            book.get().setIsbd(bookInfo.getIsbd());
            book.get().setPage(bookInfo.getPage());
            bookDAO.save(book.get());
            return book.get();
        }else{
            return null;
        }
    }

    @Override
    public bookDO getBook(String bookId) {
        Optional<bookDO> book = bookDAO.findById(bookId);
        if(book.isPresent()){
            bookDO bookInfo = bookDAO.getOne(bookId);
            return bookInfo;
        }else {
            return null;
        }
    }

    @Override
    public List<bookDO> getAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public void deleteBook(String bookId) {
        Optional<bookDO> book = bookDAO.findById(bookId);
        if(book.isPresent()){
            bookDAO.deleteById(bookId);
        }
    }
}
