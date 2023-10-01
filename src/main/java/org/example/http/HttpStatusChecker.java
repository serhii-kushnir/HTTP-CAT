package org.example.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class HttpStatusChecker {

    //private final OkHttpClient client = new OkHttpClient();

    String getStatusImage(final int statusCode) {
        return HttpResponse.getResponse(statusCode);
    }

//    private Request getRequest(final int statusCode) {
//        return new Request.Builder()
//                .url(HttpUrl.getUrl(statusCode))
//                .get()
//                .build();
//    }

//    private String getResponse(final int statusCode, final Request request) {
//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//                throw new HttpException("Cat not found by statusCode: " + statusCode);
//            }
//
//        } catch (IOException e) {
//            throw new HttpException(e.getMessage());
//        }
//
//        return HttpUrl.getUrl(statusCode);
//    }
}
