package org.whipp.serversentevents.demo.model.impl;

import lombok.Builder;
import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.constant.EventType;
import org.whipp.serversentevents.demo.model.Event;

@Service
public class UnlockEvent implements Event {

    private final String dmsId;

    public UnlockEvent(String dmsId) { this.dmsId = dmsId; }

    @Override
    public EventType getType() {
        return EventType.UNLOCK;
    }

}
