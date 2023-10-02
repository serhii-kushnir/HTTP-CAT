package org.example.file;

public class FilePatch {

    private FilePatch() {
    }

     static String getFilePatch(final int statusCode) {
        String directoryPath = "img/";
        String fileName = "Cat" + statusCode + ".jpg";
        String filePath = directoryPath + fileName;

         CreateDirectoryFile.createDirectoryIfNotExists(directoryPath);

        return filePath;
    }
}
