package org.example.http.utility;

public final class HttpUrl {
    private static final String HTTPS = "https://";
    private static final String DOMAIN = "http.cat/";
    private static final String IMAGE = ".jpg";

    private HttpUrl() {
    }

    public static String getUrl(final int statusCode) {
        return HTTPS + DOMAIN + statusCode + IMAGE;
    }
}
