package org.whipp.serversentevents.demo.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.whipp.serversentevents.demo.service.EventProducer;

public class EventControllerTest {

    @Mock
    private EventProducer eventProducer;

    @InjectMocks
    private EventController eventController;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.openMocks(this);
        eventController = new EventController(eventProducer);
    }

    @Test
    public void should_register_a_new_sse_emitter_and_return() {
        // When
        eventController.listen();

        // Then
        Mockito.verify(eventProducer, Mockito.times(1)).registerEmitter();
    }
}
