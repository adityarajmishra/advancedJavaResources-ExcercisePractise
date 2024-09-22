package com.skillovilla.java_advanced.level2;

import java.io.FileOutputStream;
import java.io.IOException;

public class BasicFileWriter {

    // Method to write data to a file using FileOutputStream
    public void writeToFile(String filePath, String content) {
        // Open the file using FileOutputStream
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            // Convert the content to bytes and write it to the file
            fileOutputStream.write(content.getBytes());
            System.out.println("Successfully written to the file.");
        } catch (IOException e) {
            // Handle IOException
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
