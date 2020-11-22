package org.whipp.serversentevents.demo.observer.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.whipp.serversentevents.demo.observer.Event;
import org.whipp.serversentevents.demo.observer.Observer;
import org.whipp.serversentevents.demo.observer.Subject;

import java.io.IOException;
import java.util.List;

@Service
public class EventProducer {

    private List<SseEmitter> sseEmitters;

    public EventProducer(List<SseEmitter> sseEmitters) {
        this.sseEmitters = sseEmitters;
    }

     public void registerEmitter(SseEmitter emitter) {
        sseEmitters.add(emitter);

        emitter.onCompletion(() -> removeEmitter(emitter));
     }

     private void removeEmitter(SseEmitter emitter) {
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
