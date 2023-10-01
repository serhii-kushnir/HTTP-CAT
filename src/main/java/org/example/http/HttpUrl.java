package org.example.http;

final class HttpUrl {

    private HttpUrl() {
    }

    private static final String HTTPS = "https://";
    private static final String DOMAIN = "http.cat/";
    private static final String IMAGE = ".jpg";

    static String getUrl(final int statusCode) {
        return HTTPS + DOMAIN + statusCode + IMAGE;
    }
}
