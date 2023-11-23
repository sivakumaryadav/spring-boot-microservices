package com.capgemini.spring.kafka.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class KafkaMessagePublisherImpl implements KafkaMessagePublisher{

    @Value("${producer.kafka.topic}")
    private String publishTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publishMessage(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(publishTopic, message);
        future.whenComplete((result, ex) -> {
            log.info("publish the message in Topic Partition : {}", result.getRecordMetadata().partition());
            if(ex == null) {
                log.info("Sent Message=[" + message + "] with Offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                log.error("Unable to send Message=[" + message + "] due to :" + ex.getMessage());
            }
        });
    }
}
