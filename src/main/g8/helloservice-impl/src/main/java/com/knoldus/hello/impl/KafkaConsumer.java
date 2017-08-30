package com.knoldus.hello.impl;

import akka.Done;
import akka.stream.javadsl.Flow;
import com.google.inject.Singleton;
import com.knoldus.kafka.KafkaService;
import com.knoldus.kafka.GreetingMessage;

import javax.inject.Inject;

@Singleton public class KafkaConsumer {

  private final KafkaService kafkaService;

  @Inject public KafkaConsumer(KafkaService kafkaService) {
    this.kafkaService = kafkaService;
    kafkaService.greetingsTopic().subscribe()
        .atLeastOnce(Flow.fromFunction(this::displayMessage));
  }

  private Done displayMessage(GreetingMessage message) {
    System.out.println("Message :::::::::::  " + message);
    return Done.getInstance();
  }

}