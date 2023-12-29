package com.rahulsharma.virtulibrarian.repository;

import com.rahulsharma.virtulibrarian.entity.BookIssuedRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookIssuedRecordRepository extends JpaRepository<BookIssuedRecord,Long>
{
}
