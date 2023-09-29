package org.example.http;

public final class HttpException extends RuntimeException {
    HttpException(final String message) {
        super(message);
    }
}
