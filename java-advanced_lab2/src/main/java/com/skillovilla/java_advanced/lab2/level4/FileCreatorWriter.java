package com.skillovilla.java_advanced.lab2.level4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreatorWriter {

    // Method to create a file and write content to it
    public void createAndWriteFile(String filePath, String content) {
        // Create a new file using the File class
        File file = new File(filePath);

        try {
            // Check if the file doesn't exist, then create it
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }

            // Open the file using FileWriter and write the provided content to the file
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(content);
                System.out.println("Successfully wrote to the file.");
            }
        } catch (IOException e) {
            // Handle any exceptions, e.g., file creation or writing errors
            e.printStackTrace();
        }
    }
}
