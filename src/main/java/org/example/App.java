package org.example;

import org.example.http.HttpStatusImageDownloader;

final class App {

    private App() {
    }

    public static void main(final String[] args) {
        System.out.println("Started program!");

        new HttpStatusImageDownloader()
                .downloadStatusImage(200);
    }
}
