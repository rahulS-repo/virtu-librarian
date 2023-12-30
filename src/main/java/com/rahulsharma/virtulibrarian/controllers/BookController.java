package com.rahulsharma.virtulibrarian.controllers;

import com.rahulsharma.virtulibrarian.entity.Book;
import com.rahulsharma.virtulibrarian.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/search")
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "genre", required = false) String genre){
        List<Book> books=null;
        if(title != null && author != null){
            books = bookService.retrieveAllBooksByAuthorAndTitle(author,title);
        } else if (title!=null) {
            books = bookService.retrieveAllBooksByTitle(title);
        } else if (author != null) {
            books = bookService.retrieveAllBooksByAuthor(author);
        } else if (genre != null) {
            books = bookService.retrieveAllBooksByGenre(genre);
        } else {
            books = bookService.retrieveAllBooks();
        }
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @PostMapping("books/add-group")
    public ResponseEntity<String> addMutipleBooks(@RequestBody List<Book> books){
        String reponse =  bookService.addMultipleBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).body(reponse);
    }

    @PostMapping("books/add-single")
    public ResponseEntity<String> addSingleBook(@RequestBody Book book){
        String reponse =  bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(reponse);
    }
}
