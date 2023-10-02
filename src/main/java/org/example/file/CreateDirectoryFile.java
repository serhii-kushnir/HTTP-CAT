package org.example.file;

import java.io.File;

public final class CreateDirectoryFile {

    private CreateDirectoryFile() {
    }

    static void createDirectoryIfNotExists(final String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() && !directory.mkdirs()) {
            System.out.println("Failed to create directory: " + directoryPath);
        }
    }
}
