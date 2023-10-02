package org.example.file;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateDirectoryFileTest {

    @Test
    void testCreateDirectoryIfNotExistsSuccess() {
        // Given
        String directoryPath = "testDirectory";

        // When
        CreateDirectoryFile.createDirectoryIfNotExists(directoryPath);
        File directory = new File(directoryPath);

        // Then
        assertTrue(directory.exists());
        assertTrue(directory.isDirectory());

        // Clean up
        assertTrue(directory.delete());
    }
}
