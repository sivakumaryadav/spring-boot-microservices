package com.capgemini.eureka.client.controller;

import com.capgemini.eureka.client.config.JWTUtil;
import com.capgemini.eureka.client.model.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class JWTController {

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "JWT Token Authenticated Successfully.";
    }


    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                            authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("invalid Credentials of username/password");
        }

        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
