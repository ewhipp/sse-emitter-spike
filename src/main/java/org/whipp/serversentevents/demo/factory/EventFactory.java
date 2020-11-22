package org.whipp.serversentevents.demo.factory;

import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.producer.Event;

import java.util.Map;

public class EventFactory {

    Map<String, Event> factoryMap;

    public EventFactory(Map<String, Event> factoryMap) {
        this.factoryMap = factoryMap;
    }

    public Event getEventFrom(String type) {
        return factoryMap.get(type).build();
    }
}
