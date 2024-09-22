package com.skillovilla.java_advanced.lab2.level3;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

    // Method to write content to a file using FileWriter
    public void writeContentToFile(String content, String filePath) {
        // Open the file using FileWriter and write the provided content
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Write the content to the file
            fileWriter.write(content);
        } catch (IOException e) {
            // Handle any exceptions, e.g., file not found or IO errors
            e.printStackTrace();
        }
    }
}
