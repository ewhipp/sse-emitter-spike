package org.whipp.serversentevents.demo.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.whipp.serversentevents.demo.service.UnlockService;

public class UnlockControllerTest {

    @Mock
    private UnlockService unlockService;

    @InjectMocks
    private UnlockController controller;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new UnlockController(unlockService);
    }

    @Test
    public void should_call_unlock_service_with_input_dmsId() {
        // Given
        final String dmsId = "test-dms-id";

        // When
        ResponseEntity<HttpStatus> actual = controller.unlockContent(dmsId);

        // Then
        Mockito.verify(unlockService, Mockito.times(1)).unlock(
                dmsId
        );

        // And Then
        Assert.assertEquals(actual.getBody(), HttpStatus.ACCEPTED);
    }
}
