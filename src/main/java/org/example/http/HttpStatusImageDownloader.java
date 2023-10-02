package org.example.http;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Response;

import org.example.file.SaveToFile;

import org.example.http.utility.HttpRequest;
import org.example.http.utility.HttpResponse;

final class HttpStatusImageDownloader {
    private final HttpStatusChecker checker = new HttpStatusChecker();

    void downloadStatusImage(final int statusCode) throws IOException {
        try (Response response = HttpResponse.getResponse(HttpRequest.getRequest(checker.getStatusImage(statusCode)))) {

            assert response.body() != null;
            InputStream input = response.body().byteStream();

            SaveToFile.saveResponseBody(input, statusCode);
        }
    }
}
