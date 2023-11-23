package com.capgemini.eureka.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config-properties")
public class PropertyController {

    @Value("${cloud.config.name}")
    private String message;

    @GetMapping("/message")
    public String getAppProperty() {
        return message;
    }
}
