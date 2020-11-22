package org.whipp.serversentevents.demo.service;

import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.producer.impl.EventProducer;
import org.whipp.serversentevents.demo.producer.impl.UnlockEvent;

@Service
public class UnlockService {
    EventProducer eventProducer;

    public UnlockService(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    public void unlock(String dmsId) {
        eventProducer.notifyEmittersOf(new UnlockEvent(dmsId));
    }
}
