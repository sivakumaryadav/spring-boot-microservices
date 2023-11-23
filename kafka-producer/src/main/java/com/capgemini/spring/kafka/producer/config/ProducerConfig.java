package com.capgemini.spring.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

public class ProducerConfig {

    @Bean
    public NewTopic createTopic() {
        return new NewTopic("", 3, (short)1);
    }
}
