package com.capgemini.api.gateway.service;

import com.capgemini.api.gateway.model.UserInfoUserDetails;
import com.capgemini.api.gateway.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.capgemini.api.gateway.model.User> user = userRepository.findByUserName(username);
        return user.map(UserInfoUserDetails::new).orElseThrow(() ->new UsernameNotFoundException(""));
        //return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
