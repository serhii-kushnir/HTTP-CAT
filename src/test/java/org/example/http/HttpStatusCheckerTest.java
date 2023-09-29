package org.example.http;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class HttpStatusCheckerTest {

    @Test
    public void testCheckStatusCod200() {
        // Given
        HttpStatusChecker hsc = new HttpStatusChecker();

        //When & Then
        try {
            assertEquals("https://http.cat/200.jpg",
                    hsc.getStatusImage(200));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCheckStatusCod404() {
        // Given
        HttpStatusChecker hsc = new HttpStatusChecker();

        //When & Then
        assertThrows(HttpException.class, () ->
                hsc.getStatusImage(600));
    }
}
