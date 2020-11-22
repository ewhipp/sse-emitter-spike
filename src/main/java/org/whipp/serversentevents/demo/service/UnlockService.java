package org.whipp.serversentevents.demo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.model.impl.UnlockEvent;

import java.util.logging.Logger;

@Service
@Log4j2
public class UnlockService {

    private EventProducer eventProducer;

    public UnlockService(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    public void unlock(String dmsId) {
        System.out.println(String.format("unlocking dmsId=[%s]",dmsId));
        eventProducer.notifyEmittersOf(new UnlockEvent(dmsId));
    }
}
