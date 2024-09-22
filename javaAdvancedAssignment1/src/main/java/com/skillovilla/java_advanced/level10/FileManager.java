package com.skillovilla.java_advanced.level10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    public void copyFile(String sourcePath, String destinationPath) {
        // Convert the string paths to Path objects
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destinationPath);

        // Use try-catch block
        try {
            // Ensure the parent directory of the destination path exists
            Files.createDirectories(destination.getParent());
            // Copy the file from source to destination
            Files.copy(source, destination);
        } catch (IOException e) {
            // Handle IOExceptions that might occur
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    public void deleteFile(String filePath) {
        // Create a File object from the filePath
        File file = new File(filePath);

        if (file.exists()) {
            // Attempt to delete the file
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.err.println("Failed to delete the file.");
            }
        } else {
            // Handle the case where the file does not exist
            System.err.println("File does not exist: " + filePath);
        }
    }
}
