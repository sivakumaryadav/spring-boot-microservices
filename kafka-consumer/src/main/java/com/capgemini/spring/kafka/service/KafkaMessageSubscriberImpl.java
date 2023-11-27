package com.capgemini.spring.kafka.service;

import com.capgemini.spring.kafka.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class KafkaMessageSubscriberImpl implements KafkaMessageSubscriber{

    /*
        Doesn't required de-serialization
     */
    @Override
    //@KafkaListener(topics = "first-topic", groupId = "consumer_group-1")
    public void consumeMessage(String message) {
        log.info("Consumer received message : {}", message);
    }

    @Override
    @KafkaListener(topics = "employee-topic", groupId = "employee_group-1")
    public void consumeEmployee(Employee employee) {
        log.info("Consumer received Employee : {}", employee.toString());
    }


}
