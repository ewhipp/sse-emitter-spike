package org.whipp.serversentevents.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.whipp.serversentevents.demo.service.EventProducer;

@RequestMapping("api/v1/event")
@RestController
public class EventController {

    EventProducer eventProducer;

    public EventController(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter listen() {
        final SseEmitter emitter = new SseEmitter(0L);

        eventProducer.registerEmitter(emitter);

        return emitter;
    }
}
