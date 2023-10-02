package org.example.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class SaveToFile {

    private SaveToFile() {
    }

    public static void saveResponseBody(final InputStream inputStream, final int statusCode) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(FilePatch.getFilePatch(statusCode))) {

            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }

            System.out.println("Image saved to file: " + FilePatch.getFilePatch(statusCode));
        }
    }
}
