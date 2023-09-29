package org.example.http;

public final class HttpException extends RuntimeException {
    public HttpException(final String message) {
        super(message);
    }
}
