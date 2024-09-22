package com.skillovilla.java_advanced.level6;

import java.io.FileWriter;
import java.io.IOException;

public class FileContentWriter {

    // Method to write content to a file
    public void writeContentToFile(String content, String filePath) {
        // Open the file using FileWriter
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Write the provided content to the file
            fileWriter.write(content);
        } catch (IOException e) {
            // Handle IOException (e.g., error writing to file)
            System.out.println("Error writing to file: " + filePath);
            e.printStackTrace();
        }
    }
}
