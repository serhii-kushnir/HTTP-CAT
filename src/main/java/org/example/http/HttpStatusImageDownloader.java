package org.example.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class HttpStatusImageDownloader {
    private final HttpStatusChecker checker = new HttpStatusChecker();
    private final OkHttpClient client = new OkHttpClient();

    public void downloadStatusImage(final int code) {
        saveResponseToFile(code, getRequest(code));
    }

    private Request getRequest(final int code) {
        return new Request.Builder()
                .url(checker.getStatusImage(code))
                .get()
                .build();
    }

    private void saveResponseToFile(final int code, final Request request) {
        try (Response response = client.newCall(request).execute()) {

            assert response.body() != null;
            saveResponseBodyToFile(response.body().byteStream(), getFilePatch(code));

            System.out.println("Image saved to file: " + getFilePatch(code));
        } catch (IOException e) {
            handleHttpException(e.getMessage());
        }
    }

    private void saveResponseBodyToFile(final InputStream inputStream, final String filePath) {
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {

            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }

        } catch (IOException e) {
            handleHttpException(e.getMessage());
        }
    }

    private String getFilePatch(final int code) {
        String directoryPath = "img/";
        String fileName = "Cat" + code + ".jpg";
        String filePath = directoryPath + fileName;

        createDirectoryIfNotExists(directoryPath);

        return filePath;
    }

    private void createDirectoryIfNotExists(final String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() && !directory.mkdirs()) {
            handleHttpException("Failed to create directory: " + directoryPath + " ");
        }
    }

    private void handleHttpException(final String message) {
        throw new HttpException(message);
    }

}
