package org.example.http;

public final class HttpStatusCheckException extends RuntimeException {
    public HttpStatusCheckException(final String message) {
        super(message);
    }
}
