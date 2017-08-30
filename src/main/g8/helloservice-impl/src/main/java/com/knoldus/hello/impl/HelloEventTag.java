package com.knoldus.hello.impl;

import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;

public class HelloEventTag {
  public static final AggregateEventTag<HelloEvent> INSTANCE =
      AggregateEventTag.of(HelloEvent.class);
}
