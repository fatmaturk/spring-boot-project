package com.project.app.controller;

import com.project.app.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.app.model.bookDO;

import java.util.List;

@RestController
@RequestMapping("/library/v1")
public class BookController {
    private IBookService bookService;

    //kitap olusturma islemi
    @PostMapping(path = "/book",consumes = "application/json",produces = "application/json")
    public ResponseEntity<bookDO> createBook(@RequestBody bookDO bookInfo){
        bookDO createdBook = bookService.createBook(bookInfo);
        return new ResponseEntity(createdBook, HttpStatus.CREATED);
    }

    //update islemi
    @PutMapping(path = "/book",consumes = "application/json",produces = "application/json")
    public ResponseEntity<bookDO> updateBook(@RequestBody bookDO bookInfo){
        bookDO updatedBook = bookService.updateBook(bookInfo);
        return new ResponseEntity(updatedBook,HttpStatus.CREATED);
    }

    //tek kitap bilgisi
    @GetMapping(path = "/book/{oid}")
    public ResponseEntity<bookDO> getBook(@PathVariable(value = "oid") String oid){
        bookDO bookInfo = bookService.getBook(oid);
        return new ResponseEntity(bookInfo,HttpStatus.OK);
    }

    //tum kitap listesi
    @GetMapping(path = "/book")
    public ResponseEntity<List<bookDO>> getAllBooks(){
        List<bookDO> allBooks = bookService.getAllBooks();
        return new ResponseEntity(allBooks,HttpStatus.OK);
    }

    //kitap sil islemi
    @DeleteMapping(path = "/book/{oid}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "oid") String  oid){
        bookService.deleteBook(oid);
        return new ResponseEntity("Başarılı!",HttpStatus.OK);
    }

}
