package org.whipp.serversentevents.demo.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.whipp.serversentevents.demo.model.impl.UnlockEvent;

public class UnlockServiceTest {

    @Mock
    private EventProducer producer;

    @InjectMocks
    private UnlockService service;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = new UnlockService(producer);
    }

    @Test
    public void should_call_event_producer_with_new_unlock_event() {
        // Given
        final String dmsId = "test-dms-id";

        // When
        service.unlock(dmsId);

        // Then
        Mockito.verify(producer, Mockito.times(1)).notifyEmittersOf(
                new UnlockEvent(dmsId)
        );
    }
}
