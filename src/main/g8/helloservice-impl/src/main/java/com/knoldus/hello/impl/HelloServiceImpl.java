package com.knoldus.hello.impl;

import akka.Done;
import akka.NotUsed;
import com.knoldus.hello.api.GreetingMessage;
import com.knoldus.hello.api.HelloService;
import com.knoldus.hello.impl.HelloCommand.Hello;
import com.knoldus.hello.impl.HelloCommand.UseGreetingMessage;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;

import javax.inject.Inject;
import java.util.Optional;

public class HelloServiceImpl implements HelloService {


    private final PersistentEntityRegistry persistentEntityRegistry;

    @Inject
    public HelloServiceImpl(PersistentEntityRegistry persistentEntityRegistry) {
        this.persistentEntityRegistry = persistentEntityRegistry;
        persistentEntityRegistry.register(HelloGreeting.class);
    }

    @Override
    public ServiceCall<NotUsed, String> hello(String id) {
        return request -> {
            PersistentEntityRef<HelloCommand> ref = persistentEntityRegistry.refFor(HelloGreeting.class, id);
            return ref.ask(new Hello(id, Optional.empty()));
        };
    }

    @Override
    public ServiceCall<GreetingMessage, Done> useGreeting(String id) {
        return request -> {
            PersistentEntityRef<HelloCommand> ref = persistentEntityRegistry.refFor(HelloGreeting.class, id);
            return ref.ask(new UseGreetingMessage(request.message));
        };
    }

}
