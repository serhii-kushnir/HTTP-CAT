package org.example.http;

import java.util.Scanner;

public class HttpImageStatusCli {

    private final HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
    public void askStatus() {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter HTTP status code");

            downloader.downloadStatusImage(scanner.nextInt());
        }
    }
}
