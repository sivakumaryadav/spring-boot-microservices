package com.capgemini.spring.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageSubscriberImpl implements KafkaMessageSubscriber{

    @Override
    @KafkaListener(topics = "employee-topic", groupId = "consumer_group-1")
    public void consumeMessage(String message) {

    }
}
