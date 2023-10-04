package org.example.http;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertThrows;

public class HttpStatusImageDownloaderTest {

    @Test
    public void testCheckHttStatusCode200() throws IOException {
        // Given
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        //When & Then

         downloader.downloadStatusImage(200);

    }
    @Test
    public void testCheckHttStatusCode404() {
        // Given
        HttpStatusImageDownloader imageDownloader = new HttpStatusImageDownloader();

        //When & Then
        assertThrows(HttpException.class, () ->
                imageDownloader.downloadStatusImage(600));
    }
}
