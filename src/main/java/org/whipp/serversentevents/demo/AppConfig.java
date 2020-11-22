package org.whipp.serversentevents.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.whipp.serversentevents.demo.factory.EventFactory;
import org.whipp.serversentevents.demo.producer.Event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public EventFactory generateEventFactory(List<Event> events) {
        Map<String, Event> mapFactory = new HashMap<>();

        for (Event event : events) {
            mapFactory.put(event.getType(), event);
        }

        return new EventFactory(mapFactory);
    }
}
