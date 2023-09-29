package org.example.http;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HttpExceptionTest {

    @Test
    public void testMessage() {
        // Given
        String errorMessage = "Error message";

        // When
        HttpException exception = new HttpException(errorMessage);

        // Then
        assertEquals(errorMessage, exception.getMessage());
    }
}