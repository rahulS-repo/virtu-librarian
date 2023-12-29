package com.rahulsharma.virtulibrarian.repository;

import com.rahulsharma.virtulibrarian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailId(String emailId);
}
