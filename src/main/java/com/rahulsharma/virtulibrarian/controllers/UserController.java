package com.rahulsharma.virtulibrarian.controllers;

import com.rahulsharma.virtulibrarian.entity.User;
import com.rahulsharma.virtulibrarian.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody User user){
        User addedUser = userService.addRegisterUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered with id: "+addedUser.getEmailId());
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfileDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Retrieve user details from the Authentication object
        String userEmailId = authentication.getName();
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserDetailsByEmail(userEmailId));
    }


}
