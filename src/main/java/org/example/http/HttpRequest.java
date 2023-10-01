package org.example.http;

import okhttp3.Request;

public final class HttpRequest {

    private HttpRequest() {
    }

    public static Request getRequest(final int statusCode) {
        return new Request.Builder()
                .url(HttpUrl.getUrl(statusCode))
                .get()
                .build();
    }
}
