package org.whipp.serversentevents.demo.model;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.whipp.serversentevents.demo.constant.EventType;
import org.whipp.serversentevents.demo.model.impl.UnlockEvent;

public class UnlockEventTest {

    @Test
    public void should_default_to_event_type_unlocked_enum() {
        // Given
        final String dmsId = "test-dms-id";

        // When
        final UnlockEvent event = new UnlockEvent(dmsId);

        // Then
        Assert.assertEquals(event.getDmsId(), dmsId);

        // And Then
        Assert.assertEquals(event.getType(), EventType.UNLOCK);
    }
}
