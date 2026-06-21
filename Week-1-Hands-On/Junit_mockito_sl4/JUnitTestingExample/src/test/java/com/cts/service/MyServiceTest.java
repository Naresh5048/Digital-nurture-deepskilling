package com.cts.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    private ExternalApi mockApi;
    private MyService service;

    @BeforeEach
    public void setUp() {
        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
    }

    @Test
    public void testMockingAndStubbing() {
        when(mockApi.getData()).thenReturn("Mock Data");

        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        service.fetchData();

        verify(mockApi, times(1)).getData();
    }

    @Test
    public void testArgumentMatching() {
        when(mockApi.processDataByTag(anyString())).thenReturn("Processed Payload");

        String result = service.processDetails("LBRCE_IT_TAG");

        assertEquals("Processed Payload", result);
        verify(mockApi).processDataByTag(eq("LBRCE_IT_TAG"));
    }

    @Test
    public void testHandlingVoidMethods() {
        doNothing().when(mockApi).updateRecord("REC_101");

        service.saveSystemRecord("REC_101");

        verify(mockApi).updateRecord("REC_101");
    }

    @Test
    public void testMultipleReturnValues() {
        when(mockApi.getData())
                .thenReturn("First Call Data")
                .thenReturn("Second Call Data");

        assertEquals("First Call Data", service.fetchData());
        assertEquals("Second Call Data", service.fetchData());
    }

    @Test
    public void testVerifyingInteractionOrder() {
        service.fetchData();
        service.saveSystemRecord("REC_999");

        InOrder inOrderVerifier = inOrder(mockApi);

        inOrderVerifier.verify(mockApi).getData();
        inOrderVerifier.verify(mockApi).updateRecord("REC_999");
    }
    @Test
    public void testVoidMethodWithException() {
        doThrow(new RuntimeException("Database Engine Out of Sync"))
                .when(mockApi).updateRecord("CORRUPT_ID");

        assertThrows(RuntimeException.class, () -> {
            service.saveSystemRecord("CORRUPT_ID");
        });
    }
}