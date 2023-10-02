package org.example.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.example.http.HttpException;

public final class SaveToFile {

    private SaveToFile() {
    }

    public static void saveResponseBody(final InputStream inputStream, final int statusCode) {
        try (FileOutputStream outputStream = new FileOutputStream(getFilePatch(statusCode))) {

            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }

            System.out.println("Image saved to file: " + getFilePatch(statusCode));
        } catch (IOException e) {
            throw new HttpException(e.getMessage());
        }
    }

    private static String getFilePatch(final int statusCode) {
        String directoryPath = "img/";
        String fileName = "Cat" + statusCode + ".jpg";
        String filePath = directoryPath + fileName;

        createDirectoryIfNotExists(directoryPath);

        return filePath;
    }

    private static void createDirectoryIfNotExists(final String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() && !directory.mkdirs()) {
            throw new HttpException("Failed to create directory: " + directoryPath + " ");
        }
    }
}
