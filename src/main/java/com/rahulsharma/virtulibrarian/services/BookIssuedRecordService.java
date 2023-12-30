package com.rahulsharma.virtulibrarian.services;

import com.rahulsharma.virtulibrarian.entity.Book;
import com.rahulsharma.virtulibrarian.entity.BookIssuedRecord;
import com.rahulsharma.virtulibrarian.entity.User;
import com.rahulsharma.virtulibrarian.repository.BookIssuedRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookIssuedRecordService {

    @Autowired
    private BookIssuedRecordRepository bookIssuedRecordRepository;


    public List<BookIssuedRecord> getBorrowedBooksByUser(User user){
        return bookIssuedRecordRepository.findByUser(user);
    }

    public void borrowBook(Book book, User user){
        Date issueDate = new Date();

        // Set the returnDate to the current date + 15 days
        long returnDateMillis = issueDate.getTime() + (15 * 24 * 60 * 60 * 1000); // 15 days in milliseconds
        Date returnDate = new Date(returnDateMillis);

        BookIssuedRecord issuedRecord = BookIssuedRecord
                .builder()
                .user(user)
                .book(book)
                .issueDate(issueDate)
                .returnDate(returnDate).build();
        bookIssuedRecordRepository.save(issuedRecord);
    }
}
