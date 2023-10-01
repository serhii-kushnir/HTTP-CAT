package org.example.http;

import java.io.IOException;

import okhttp3.Response;

final class HttpStatusChecker {

    String getStatusImage(final int statusCode) {
        try (Response response = HttpResponse.getResponse(statusCode)) {

            if (!response.isSuccessful()) {
                throw new HttpException("Cat not found by statusCode: " + statusCode);
            }

        } catch (IOException e) {
            throw new HttpException(e.getMessage());
        }

        return HttpUrl.getUrl(statusCode);
    }
}
