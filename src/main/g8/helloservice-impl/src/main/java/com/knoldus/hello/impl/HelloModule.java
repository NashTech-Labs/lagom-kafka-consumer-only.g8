package com.knoldus.hello.impl;

import com.google.inject.AbstractModule;
import com.knoldus.hello.api.HelloService;
import com.knoldus.hello.kafka.KafkaConsumer;
import com.knoldus.kafka.KafkaService;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class HelloModule extends AbstractModule implements ServiceGuiceSupport {

    @Override
    protected void configure() {
        bindService(HelloService.class, HelloServiceImpl.class);
        bindClient(KafkaService.class);
        bind(KafkaConsumer.class).asEagerSingleton();
    }
}
