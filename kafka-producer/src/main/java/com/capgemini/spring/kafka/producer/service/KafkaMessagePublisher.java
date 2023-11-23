package com.capgemini.spring.kafka.producer.service;

public interface KafkaMessagePublisher {

    public void publishMessage(String message);
}
