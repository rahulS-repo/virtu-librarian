package com.rahulsharma.virtulibrarian.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookIssuedRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "issue_seq")
    @SequenceGenerator(name = "issue_seq", sequenceName = "issue_sequence", initialValue = 30001, allocationSize = 1)
    @JsonIgnore
    private Long issueId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @Temporal(TemporalType.DATE)
    private Date returnDate;
}
