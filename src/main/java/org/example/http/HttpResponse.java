package org.example.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Response;

public final class HttpResponse {
    private static final OkHttpClient client = new OkHttpClient();

    private HttpResponse() {
    }

    public static String getResponse(final int statusCode) {
        try (Response response = client.newCall(HttpRequest.getRequest(statusCode)).execute()) {
            if (!response.isSuccessful()) {
                throw new HttpException("Cat not found by statusCode: " + statusCode);
            }

        } catch (IOException e) {
            throw new HttpException(e.getMessage());
        }

        return HttpUrl.getUrl(statusCode);
    }
}
