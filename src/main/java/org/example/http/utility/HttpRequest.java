package org.example.http.utility;

import okhttp3.Request;

public final class HttpRequest {

    private HttpRequest() {
    }

    public static Request getRequest(final String url) {
        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }
}
