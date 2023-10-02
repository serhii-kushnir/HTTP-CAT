package org.example.http.utility;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class HttpResponse {
    private static final OkHttpClient CLIENT = new OkHttpClient();

    private HttpResponse() {
    }

    public static Response getResponse(final Request request) throws IOException {
        return CLIENT.newCall(request).execute();
    }
}
