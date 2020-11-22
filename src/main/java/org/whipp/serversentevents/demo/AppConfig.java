package org.whipp.serversentevents.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.whipp.serversentevents.demo.observer.Event;
import org.whipp.serversentevents.demo.observer.Observer;
import org.whipp.serversentevents.demo.observer.impl.EventProducer;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public EventProducer eventProducer(List<Observer<Event>> observers) {
        return new EventProducer(observers);
    }
}
