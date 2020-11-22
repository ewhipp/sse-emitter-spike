package org.whipp.serversentevents.demo.observer.impl;

import org.whipp.serversentevents.demo.observer.Event;

public class UnlockEvent implements Event {

    private String dmsId;

    public UnlockEvent(String dmsId) { this.dmsId = dmsId; }

    @Override
    public String getType() {
        return "UNLOCK";
    }
}
