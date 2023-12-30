package com.rahulsharma.virtulibrarian.repository;

import com.rahulsharma.virtulibrarian.entity.BookIssuedRecord;
import com.rahulsharma.virtulibrarian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookIssuedRecordRepository extends JpaRepository<BookIssuedRecord,Long> {
    List<BookIssuedRecord> findByUser(User user);
}
