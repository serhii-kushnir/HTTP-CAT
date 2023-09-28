package org.example.http;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HttpStatusCheckExceptionTest {

    @Test
    public void testMessage() {
        // Given
        String errorMessage = "Error message";

        // When
        HttpStatusCheckException exception = new HttpStatusCheckException(errorMessage);

        // Then
        assertEquals(errorMessage, exception.getMessage());
    }
}