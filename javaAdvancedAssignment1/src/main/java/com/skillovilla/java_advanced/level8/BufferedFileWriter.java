package com.skillovilla.java_advanced.level8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileWriter {

    // Method to write content to a file using BufferedWriter
    public void writeToFile(String filePath, String content) {
        // Open the file using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            // Write the provided content to the file
            bufferedWriter.write(content);
        } catch (IOException e) {
            // Handle IOException (e.g., error writing to file)
            System.out.println("Error writing to file: " + filePath);
            e.printStackTrace();
        }
    }
}
