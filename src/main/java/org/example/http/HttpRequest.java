package org.example.http;

import okhttp3.Request;

final class HttpRequest {

    private HttpRequest() {
    }

    static Request getRequest(final int statusCode) {
        return new Request.Builder()
                .url(HttpUrl.getUrl(statusCode))
                .get()
                .build();
    }
}
