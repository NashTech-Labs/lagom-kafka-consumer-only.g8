package com.knoldus.hello.kafka;

import akka.Done;
import akka.stream.javadsl.Flow;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Singleton;
import com.knoldus.kafka.KafkaService;
import com.knoldus.kafka.GreetingMessage;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

@Singleton
public class KafkaConsumer {

    private final ObjectMapper jsonMapper = new ObjectMapper();

    @Inject
    public KafkaConsumer(KafkaService kafkaService) {
        kafkaService.greetingsTopic().subscribe()
                .atLeastOnce(Flow.fromFunction(this::displayMessage));
    }

    private Done displayMessage(String message) {
        System.out.println("Message :::::::::::  " + message);
        try {
            GreetingMessage greetingMessage = jsonMapper.readValue(message, GreetingMessage.class);
            if (StringUtils.isNotEmpty(greetingMessage.message)) {
                System.out.println("Action performed :::::::::::  " + message);

                // Do your action here
            }
        } catch (Exception ex) {
            System.out.println("Error in consuming kafka message");
        }
        return Done.getInstance();
    }
}