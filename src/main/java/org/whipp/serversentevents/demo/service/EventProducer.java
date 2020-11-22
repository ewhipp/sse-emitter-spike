package org.whipp.serversentevents.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import netscape.javascript.JSObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.whipp.serversentevents.demo.model.Event;

import java.io.IOException;
import java.util.*;

@Service
public class EventProducer {

    private Collection<SseEmitter> sseEmitters;

    public EventProducer(List<SseEmitter> sseEmitters) {
        this.sseEmitters = sseEmitters;
    }

     public void registerEmitter(SseEmitter emitter) {
        sseEmitters.add(emitter);
        emitter.onTimeout(() -> removeEmitter(emitter));
        emitter.onCompletion(() -> removeEmitter(emitter));
     }

     public void notifyEmittersOf(Event event) {
        sseEmitters.forEach(emitter -> emitEvent(event, emitter));
     }

     private void removeEmitter(SseEmitter emitter) {
        emitter.complete();
        sseEmitters.remove(emitter);
     }

     private void emitEvent(Event event, SseEmitter emitter) {
         try {
             System.out.println(String.format("state=[emit event],event=[%s],emitter=[%s]", event, emitter));
             emitter.send(SseEmitter.event().name(event.getType().toString()).data(event));
         } catch (IOException e) {
             emitter.complete();
             throw new RuntimeException();
         }
     }

}
