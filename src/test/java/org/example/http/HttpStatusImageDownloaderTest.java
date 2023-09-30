package org.example.http;

import org.junit.Test;

import static org.junit.Assert.*;

public class HttpStatusImageDownloaderTest {

    @Test
    public void testCheckStatusCod200() {
        // Given
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        //When & Then
        downloader.downloadStatusImage(200);
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
