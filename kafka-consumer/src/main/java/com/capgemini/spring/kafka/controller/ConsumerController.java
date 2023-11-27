package com.capgemini.spring.kafka.controller;

import com.capgemini.spring.kafka.service.KafkaMessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private KafkaMessageSubscriber subscriber;

    @GetMapping("/message")
    public ResponseEntity<?> consumeMessage() {
        //subscriber.consumeMessage();
        return ResponseEntity.ok("");
    }
}
