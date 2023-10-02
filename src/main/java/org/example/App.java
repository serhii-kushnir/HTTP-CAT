package org.example;

import org.example.http.HttpImageStatusCli;

final class App {

   private static final HttpImageStatusCli IMAGE_STATUS_CLI = new HttpImageStatusCli();

    private App() {
    }

    public static void main(final String[] args) {
        IMAGE_STATUS_CLI.askStatus();
    }
}
