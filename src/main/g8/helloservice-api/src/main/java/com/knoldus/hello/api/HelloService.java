package com.knoldus.hello.api;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

public interface HelloService extends Service {

    ServiceCall<String, String> hello(String id);

    @Override
    default Descriptor descriptor() {
        return named("helloservice").withCalls(
                pathCall("/api/hello/:id", this::hello)
        ).withAutoAcl(true);
    }
}