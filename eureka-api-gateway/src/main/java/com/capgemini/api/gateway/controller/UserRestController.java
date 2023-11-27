package com.capgemini.api.gateway.controller;

import com.capgemini.api.gateway.model.User;
import com.capgemini.api.gateway.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @PostMapping("/insertUsers")
    public String insertUsers(@RequestBody List<User> users) {
        users.stream()
                .forEach(user -> user.setPassword(passwordEncoder.encode(user.getPassword())));
        userDetailsRepository.saveAll(users);
        return "Users added Successfully.";
    }
}
