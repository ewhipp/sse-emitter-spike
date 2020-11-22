package org.whipp.serversentevents.demo.producer;

public interface Event {
    String getType();
    Event build();
}
