package com.knoldus.hello.impl;

import akka.Done;
import com.knoldus.hello.impl.HelloCommand.Hello;
import com.knoldus.hello.impl.HelloCommand.UseGreetingMessage;
import com.knoldus.hello.impl.HelloEvent.GreetingMessageChanged;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;

import java.time.LocalDateTime;
import java.util.Optional;

public class HelloGreeting extends PersistentEntity<HelloCommand, HelloEvent, WorldState> {

    @Override
    public Behavior initialBehavior(Optional<WorldState> snapshotState) {

        BehaviorBuilder b = newBehaviorBuilder(
                snapshotState.orElse(new WorldState("Hello", LocalDateTime.now().toString())));

        b.setCommandHandler(UseGreetingMessage.class, (cmd, ctx) ->
                ctx.thenPersist(new GreetingMessageChanged(cmd.message),
                        // Then once the event is successfully persisted, we respond with done.
                        evt -> ctx.reply(Done.getInstance())));

        b.setEventHandler(GreetingMessageChanged.class,
                evt -> new WorldState(evt.message, LocalDateTime.now().toString()));

        b.setReadOnlyCommandHandler(Hello.class,
                (cmd, ctx) -> ctx.reply(state().message + ", " + cmd.name + "!"));

        return b.build();
    }

}
