package org.example.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.example.http.HttpException;

public final class SaveToFile {

    private SaveToFile() {
    }

    public static void saveResponseBody(final InputStream inputStream, final int statusCode) {
        try (FileOutputStream outputStream = new FileOutputStream(FilePatch.getFilePatch(statusCode))) {

            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }

            System.out.println("Image saved to file: " + FilePatch.getFilePatch(statusCode));
        } catch (IOException e) {
            throw new HttpException(e.getMessage());
        }
    }
}
