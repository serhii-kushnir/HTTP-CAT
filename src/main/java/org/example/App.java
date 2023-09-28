package org.example;

import org.example.http.HttpStatusChecker;

public final class App {

    private App() {
    }

    public static void main(final String[] args) {
        System.out.println("Started program!");

        System.out.println(new HttpStatusChecker()
                .getStatusImage(200));
    }
}
