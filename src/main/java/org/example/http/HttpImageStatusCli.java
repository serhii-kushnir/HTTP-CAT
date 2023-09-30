package org.example.http;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class HttpImageStatusCli {
    private final HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    public void askStatus() {
        int statusCode = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter HTTP status code");
            statusCode = scanner.nextInt();

            downloader.downloadStatusImage(statusCode);

        } catch (HttpException e) {
            System.out.println("There is not image for HTTP status " + statusCode);
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
        }
    }
}
