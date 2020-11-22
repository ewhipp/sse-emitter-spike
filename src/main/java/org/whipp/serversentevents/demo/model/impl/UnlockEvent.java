package org.whipp.serversentevents.demo.model.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.whipp.serversentevents.demo.constant.EventType;
import org.whipp.serversentevents.demo.model.Event;

@Service
@NoArgsConstructor
public class UnlockEvent implements Event {

    private String dmsId;

    public UnlockEvent(String dmsId) { this.dmsId = dmsId; }

    @Override
    public EventType getType() {
        return EventType.UNLOCK;
    }

}
