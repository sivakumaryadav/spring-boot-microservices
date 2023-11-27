package com.capgemini.spring.kafka.service;

import com.capgemini.spring.kafka.model.Employee;

public interface KafkaMessageSubscriber {

    public void consumeMessage(String message);

    public void consumeEmployee(Employee employee);
}
