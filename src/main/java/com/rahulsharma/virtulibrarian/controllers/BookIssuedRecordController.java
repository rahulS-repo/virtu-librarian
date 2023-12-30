package com.rahulsharma.virtulibrarian.controllers;

import com.rahulsharma.virtulibrarian.entity.Book;
import com.rahulsharma.virtulibrarian.entity.BookIssuedRecord;
import com.rahulsharma.virtulibrarian.entity.User;
import com.rahulsharma.virtulibrarian.services.BookIssuedRecordService;
import com.rahulsharma.virtulibrarian.services.BookService;
import com.rahulsharma.virtulibrarian.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookIssuedRecordController {

    @Autowired
    private BookIssuedRecordService recordService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/my-library")
    public ResponseEntity<List<BookIssuedRecord>> getAllBorrowedBook(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Retrieve user details from the Authentication object
        String userEmailId = authentication.getName();
        User loggedInUser = userService.getUserDetailsByEmail(userEmailId);
        List<BookIssuedRecord> records=null;
        records = recordService.getBorrowedBooksByUser(loggedInUser);
        return ResponseEntity.status(HttpStatus.OK).body(records);


    }

    @PostMapping("/borrow-book")
    public ResponseEntity<String> borrowBook(@RequestParam(value = "id") Long bookId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmailId = authentication.getName();
        User loggedInUser = userService.getUserDetailsByEmail(userEmailId);
        Book fetchedBook = bookService.getBookById(bookId);
        recordService.borrowBook(fetchedBook,loggedInUser);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Book is issued and available in your library");

    }

}
