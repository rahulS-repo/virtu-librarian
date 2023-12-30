package com.rahulsharma.virtulibrarian.repository;

import com.rahulsharma.virtulibrarian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmailId(String emailId);
}
