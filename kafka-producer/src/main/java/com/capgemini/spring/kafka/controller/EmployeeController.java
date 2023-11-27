package com.capgemini.spring.kafka.controller;

import com.capgemini.spring.kafka.model.Employee;
import com.capgemini.spring.kafka.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EmployeeController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {
            publisher.publishMessage(message);
            return ResponseEntity.ok("Successfully Publish message.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish/employee")
    public ResponseEntity<?> publishEmployee(@RequestBody Employee employee) {
        try {
            publisher.publishEmployee(employee);
            return ResponseEntity.ok("Successfully Publish message.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
