package org.example.http;

import java.io.IOException;

import okhttp3.Response;

import org.example.http.utility.HttpRequest;
import org.example.http.utility.HttpResponse;
import org.example.http.utility.HttpUrl;

final class HttpStatusChecker {

    String getStatusImage(final int statusCode) throws IOException {
        try (Response response = HttpResponse.getResponse(HttpRequest.getRequest(HttpUrl.getUrl(statusCode)))) {

            if (!response.isSuccessful()) {
                throw new HttpException("Cat not found by statusCode: " + statusCode);
            }

        }
        return HttpUrl.getUrl(statusCode);
    }
}
