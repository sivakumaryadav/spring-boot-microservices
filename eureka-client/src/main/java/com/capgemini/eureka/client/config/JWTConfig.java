package com.capgemini.eureka.client.config;

import com.capgemini.eureka.client.service.CustomUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class JWTConfig extends WebSecurityConfigurerAdapter {

    private CustomUserDetailsService userDetailsService;

    @Override
    public void setAuthenticationConfiguration(AuthenticationConfiguration auth) {
        
    }


}
