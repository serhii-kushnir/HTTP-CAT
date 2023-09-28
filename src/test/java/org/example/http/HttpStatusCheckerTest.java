package org.example.http;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class HttpStatusCheckerTest {

    @Test
    public void testCheckStatusCod200() {
        // Given
        HttpStatusChecker hsc = new HttpStatusChecker();

        //When & Then
        assertEquals("https://http.cat/200.jpg",
                hsc.getStatusImage(200));
    }

    @Test
    public void testCheckStatusCod404() {
        // Given
        HttpStatusChecker hsc = new HttpStatusChecker();

        //When & Then
        assertThrows(HttpStatusCheckException.class, () ->
                hsc.getStatusImage(600));
    }
}
