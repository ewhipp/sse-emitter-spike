package org.whipp.serversentevents.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.whipp.serversentevents.demo.producer.impl.EventProducer;
import org.whipp.serversentevents.demo.producer.impl.UnlockEvent;
import org.whipp.serversentevents.demo.service.UnlockService;


@RequestMapping("api/v1/event/unlock")
@RestController
public class UnlockController {

    UnlockService service;
    EventProducer eventProducer;

    @Autowired
    public UnlockController(UnlockService service, EventProducer producer) {
        this.service = service;
        this.eventProducer = producer;
    }

    @PutMapping
    ResponseEntity<HttpStatus> unlockContent(@RequestParam String dmsId) {
        service.unlock(String.valueOf(dmsId));
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter unlockEvent() {
        final SseEmitter emitter = new SseEmitter(0L);

        eventProducer.registerEmitter(emitter);

        return emitter;
    }

}
