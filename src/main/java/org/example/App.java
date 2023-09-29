package org.example;

import org.example.http.HttpImageStatusCli;

final class App {

   private final static HttpImageStatusCli HTTP_IMAGE_STATUS_CLI = new HttpImageStatusCli();

    private App() {
    }

    public static void main(final String[] args) {
        System.out.println("Started program!");
        HTTP_IMAGE_STATUS_CLI.askStatus();
    }
}
