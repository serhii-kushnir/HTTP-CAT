package org.example.http;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Response;
import org.example.file.SaveToFile;
import org.example.http.utility.HttpRequest;
import org.example.http.utility.HttpResponse;

final class HttpStatusImageDownloader {
    private final HttpStatusChecker checker = new HttpStatusChecker();

    void downloadStatusImage(final int statusCode) {
        try (Response response = HttpResponse.getResponse(HttpRequest.getRequest(checker.getStatusImage(statusCode)))) {

            assert response.body() != null;
            InputStream Input = response.body().byteStream();

            SaveToFile.saveResponseBody(Input, statusCode);

//            System.out.println("Image saved to file: " + getFilePatch(statusCode));
        } catch (IOException e) {
            throw new HttpException(e.getMessage());
        }
    }


   /* private String getFilePatch(final int code) {
        String directoryPath = "img/";
        String fileName = "Cat" + code + ".jpg";
        String filePath = directoryPath + fileName;

        createDirectoryIfNotExists(directoryPath);

        return filePath;
    }

    private void createDirectoryIfNotExists(final String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() && !directory.mkdirs()) {
            throw new HttpException("Failed to create directory: " + directoryPath + " ");
        }
    }*/
}
