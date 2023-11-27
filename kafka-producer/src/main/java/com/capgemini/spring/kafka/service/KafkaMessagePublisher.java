package com.capgemini.spring.kafka.service;

import com.capgemini.spring.kafka.model.Employee;

public interface KafkaMessagePublisher {

    public void publishMessage(String message);

    void publishEmployee(Employee employee);
}
