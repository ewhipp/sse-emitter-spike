package org.whipp.serversentevents.demo.service;

import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.model.impl.UnlockEvent;

@Service
public class UnlockService {

    private EventProducer eventProducer;

    public UnlockService(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    public void unlock(String dmsId) {
        eventProducer.notifyEmittersOf(new UnlockEvent(dmsId));
    }
}
