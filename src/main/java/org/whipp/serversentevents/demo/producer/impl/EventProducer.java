package org.whipp.serversentevents.demo.producer.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.whipp.serversentevents.demo.factory.EventFactory;
import org.whipp.serversentevents.demo.producer.Event;

import java.io.IOException;
import java.util.*;

@Service
public class EventProducer {

    private Collection<SseEmitter> sseEmitters;
    private EventFactory factory;

    public EventProducer(List<SseEmitter> sseEmitters, EventFactory factory) {
        this.factory = factory;
        this.sseEmitters = sseEmitters;
    }

     public void registerEmitter(SseEmitter emitter) {
        sseEmitters.add(emitter);
        emitter.onTimeout(() -> removeEmitter(emitter));
        emitter.onCompletion(() -> removeEmitter(emitter));
     }

     private void removeEmitter(SseEmitter emitter) {
        emitter.complete();
        sseEmitters.remove(emitter);
     }

     public void notifyEmittersOf(Event event) {
        sseEmitters.forEach(emitter-> {
            try {
                emitter.send(SseEmitter.event().name(event.getType()).data(event));
            } catch (IOException e) {
                emitter.complete();
                 e.printStackTrace();
            }
        });
     }

}
