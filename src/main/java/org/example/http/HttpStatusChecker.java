package org.example.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class HttpStatusChecker {

    public static final String HTTPS = "https://";
    public static final String DOMAIN = "http.cat/";
    public static final String IMAGE = ".jpg";
    private final OkHttpClient client = new OkHttpClient();

    public String getStatusImage(final int code) {
        return getResponse(code, getRequest(code));
    }

    private String getResponse(final int code, final Request request) {
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                getHttpExeption(code);
            }

        } catch (IOException e) {
            getHttpExeption(code);
        }

        return getUrl(code);
    }

    private static void getHttpExeption(final int code) {
        throw new HttpStatusCheckException("Cat not found by code: " + code);
    }

    private Request getRequest(final int code) {
        return new Request.Builder()
                .url(getUrl(code))
                .get()
                .build();
    }

    private static String getUrl(final int code) {
        return HTTPS + DOMAIN + code + IMAGE;
    }
}
