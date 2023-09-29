package org.example.http;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HttpStatusImageDownloaderTest {

    @Test
    public void testCheckStatusCod200() {
        // Given
        HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();

        //When & Then
        try {
            imageDownloader.downloadStatusImage(200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testCheckStatusCod404() {
        // Given
        HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();

        //When & Then
        assertThrows(HttpException.class, () ->
                imageDownloader.downloadStatusImage(600));
    }
}