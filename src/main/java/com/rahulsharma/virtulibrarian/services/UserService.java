package com.rahulsharma.virtulibrarian.services;

import com.rahulsharma.virtulibrarian.entity.User;
import com.rahulsharma.virtulibrarian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserDetailsByEmail(String emailId){
        return userRepository.findByEmailId(emailId).orElseThrow();
    }

    public User addRegisterUser(User user){
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        return userRepository.save(user);
    }

}
