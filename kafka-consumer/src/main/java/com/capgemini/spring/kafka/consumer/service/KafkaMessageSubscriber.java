package com.capgemini.spring.kafka.consumer.service;

public interface KafkaMessageSubscriber {

    public void consumeMessage(String message);
}
