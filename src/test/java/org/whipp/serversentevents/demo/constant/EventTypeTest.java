package org.whipp.serversentevents.demo.constant;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EventTypeTest {

    @Test
    public void value_of_unlocked_event_should_be() {
        Assert.assertEquals(EventType.UNLOCK.toString(), "UNLOCK");
    }

}
