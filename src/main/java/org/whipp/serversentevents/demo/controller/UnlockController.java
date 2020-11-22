package org.whipp.serversentevents.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.whipp.serversentevents.demo.observer.Event;
import org.whipp.serversentevents.demo.observer.Observer;
import org.whipp.serversentevents.demo.observer.impl.EventProducer;
import org.whipp.serversentevents.demo.observer.impl.UnlockEvent;
import org.whipp.serversentevents.demo.service.UnlockService;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RequestMapping("api/v1/event/unlock")
@RestController
public class UnlockController implements Observer<UnlockEvent> {

    UnlockService service;
    EventProducer eventProducer;

    @Autowired
    public UnlockController(UnlockService service, EventProducer producer) {
        this.service = service;
        this.eventProducer = producer;
    }

    @PutMapping
    ResponseEntity<HttpStatus> unlockContent(@RequestParam int dmsId) {
        service.unlock(String.valueOf(dmsId));
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter unlockEvent(UnlockEvent event) {
        final SseEmitter emitter = new SseEmitter();

        eventProducer.registerEmitter(emitter);

        return emitter;
    }

    @Override
    public void update(UnlockEvent e) {
        unlockEvent(e);
    }

}
