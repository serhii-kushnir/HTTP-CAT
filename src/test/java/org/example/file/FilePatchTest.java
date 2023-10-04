package org.example.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilePatchTest {

    @Test
    void testGetFilePatchHttpStatusCode200() {
        // Given
        String filePath = FilePatch.getFilePatch(200);

        //When & Then
        assertEquals("img/Cat200.jpg", filePath);
    }

    @Test
    void testGetFilePatchHttStatusCode404() {
        // Given
        String filePath = FilePatch.getFilePatch(404);

        //When & Then
        assertEquals("img/Cat404.jpg", filePath);
    }
}
