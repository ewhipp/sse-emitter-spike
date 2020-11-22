package org.whipp.serversentevents.demo.producer.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.producer.Event;

@Service
public class UnlockEvent implements Event {

    private String dmsId;

    public UnlockEvent(String dmsId) { this.dmsId = dmsId; }

    public UnlockEvent() { }

    @Override
    public String getType() {
        return "UNLOCK";
    }

    public String getDmsId() { return dmsId; }

    public UnlockEvent build() {
        return new UnlockEvent(getDmsId());
    }
}
