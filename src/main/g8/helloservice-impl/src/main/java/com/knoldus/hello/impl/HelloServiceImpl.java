package com.knoldus.hello.impl;

import com.knoldus.hello.api.HelloService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;

public class HelloServiceImpl implements HelloService {

    @Override
    public ServiceCall<String, String> hello(String name) {
        return request -> (
                CompletableFuture.completedFuture("Hello " + name + ". Have a nice day !")
        );
    }
}
