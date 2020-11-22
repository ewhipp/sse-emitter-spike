package org.whipp.serversentevents.demo.producer.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.whipp.serversentevents.demo.factory.EventFactory;
import org.whipp.serversentevents.demo.producer.Event;

import java.io.IOException;
import java.util.List;

@Service
public class EventProducer {

    private List<SseEmitter> sseEmitters;
    private EventFactory factory;

    public EventProducer(List<SseEmitter> sseEmitters, EventFactory factory) {
        this.factory = factory;
        this.sseEmitters = sseEmitters;
    }

     public void registerEmitter(SseEmitter emitter) {
        sseEmitters.add(emitter);
     }

     public void removeEmitter(SseEmitter emitter) {
        sseEmitters.remove(emitter);
     }

     public void notifyEmittersOf(Event event) {
        sseEmitters.forEach(emitter-> {
            try {
                emitter.send(SseEmitter.event().name(event.getType()).data(event));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
     }

}
