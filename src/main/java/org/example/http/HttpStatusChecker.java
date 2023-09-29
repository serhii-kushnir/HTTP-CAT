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

    String getStatusImage(final int code) {
        return getResponse(code, getRequest(code));
    }

    private Request getRequest(final int code) {
        return new Request.Builder()
                .url(getUrl(code))
                .get()
                .build();
    }

    private String getResponse(final int code, final Request request) {
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                handleHttpException("Cat not found by code: ", code);
            }

        } catch (IOException e) {
            handleHttpException(e.getMessage());
        }

        return getUrl(code);
    }

    private void handleHttpException(final String message) {
        throw new HttpException(message);
    }

    private void handleHttpException(final String message, final int code) {
        throw new HttpException(message + code);
    }

    private static String getUrl(final int code) {
        return HTTPS + DOMAIN + code + IMAGE;
    }
}
