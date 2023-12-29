package com.rahulsharma.virtulibrarian.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", sequenceName = "book_sequence", initialValue = 20001, allocationSize = 1)
    private Long bookId;
    private String title;
    private String genre;
    private String author;
    private String description;
    private String isbn;

}
