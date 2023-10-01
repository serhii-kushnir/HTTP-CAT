package org.example.http;

final class HttpException extends RuntimeException {

    HttpException(final String message) {
        super(message);
    }
}
