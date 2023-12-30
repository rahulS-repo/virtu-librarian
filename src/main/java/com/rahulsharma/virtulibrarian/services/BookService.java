package com.rahulsharma.virtulibrarian.services;

import com.rahulsharma.virtulibrarian.entity.Book;
import com.rahulsharma.virtulibrarian.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> retrieveAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> retrieveAllBooksByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }
    public List<Book> retrieveAllBooksByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public List<Book> retrieveAllBooksByGenre(String genre){
        return bookRepository.findByGenre(genre);
    }
    public List<Book> retrieveAllBooksByAuthorAndTitle(String author, String title){
        return bookRepository.findByAuthorAndTitle(author, title);
    }

    public String addMultipleBooks(List<Book> books){
        bookRepository.saveAll(books);
        return "All books are saved";
    }
    public String addBook(Book book){
        Book savedBook = bookRepository.save(book);
        return "Book saved with id: "+savedBook.getBookId();
    }
    public Book getBookById(Long bookId){
        return bookRepository.findById(bookId).orElse(null);
    }
}
