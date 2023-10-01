package org.example.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Response;

final class HttpResponse {
    private static final OkHttpClient CLIENT = new OkHttpClient();

    private HttpResponse() {
    }

    static Response getResponse(final int statusCode) throws IOException {
        return CLIENT.newCall(HttpRequest.getRequest(statusCode)).execute();
    }
}
