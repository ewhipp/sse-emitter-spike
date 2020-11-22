package org.whipp.serversentevents.demo.model.impl;

import lombok.*;
import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.constant.EventType;
import org.whipp.serversentevents.demo.model.Event;

@Service
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UnlockEvent implements Event {

    private String dmsId;
    private EventType eventType;

    public UnlockEvent(String dmsId) {
        this.dmsId = dmsId;
        this.eventType = getType();
    }

    @Override
    public EventType getType() {
        return EventType.UNLOCK;
    }

    public String getDmsId() {
        return dmsId;
    }
}
