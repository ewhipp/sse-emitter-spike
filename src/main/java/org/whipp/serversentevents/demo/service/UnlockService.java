package org.whipp.serversentevents.demo.service;

import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.observer.impl.EventProducer;
import org.whipp.serversentevents.demo.observer.impl.UnlockEvent;

@Service
public class UnlockService {
    EventProducer eventProducer;

    public UnlockService(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    public void unlock(String dmsId) {
        System.out.println("unlocking content");
        eventProducer.notifyObservers(new UnlockEvent(dmsId));
    }
}
