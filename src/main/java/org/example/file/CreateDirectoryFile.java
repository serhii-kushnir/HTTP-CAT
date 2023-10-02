package org.example.file;

import java.io.File;

import org.example.http.HttpException;

public class CreateDirectoryFile {

    private CreateDirectoryFile() {
    }

    static void createDirectoryIfNotExists(final String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() && !directory.mkdirs()) {
            throw new HttpException("Failed to create directory: " + directoryPath + " ");
        }
    }
}
