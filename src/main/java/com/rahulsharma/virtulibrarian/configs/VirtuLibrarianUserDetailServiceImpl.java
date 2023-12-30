package com.rahulsharma.virtulibrarian.configs;

import com.rahulsharma.virtulibrarian.entity.User;
import com.rahulsharma.virtulibrarian.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VirtuLibrarianUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String email,password=null;
        List<GrantedAuthority> roles=null;
        User fetchedUser = userService.getUserDetailsByEmail(username);
        if(fetchedUser==null){
            throw new UsernameNotFoundException("User not found with username: "+username);
        }else{
            email = fetchedUser.getEmailId();
            password = fetchedUser.getPassword();
            roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(fetchedUser.getRole()));

        }


        return new org.springframework.security.core.userdetails.User(email,password,roles);
    }
}
