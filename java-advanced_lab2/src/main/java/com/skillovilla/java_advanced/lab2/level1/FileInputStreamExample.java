package com.skillovilla.java_advanced.lab2.level1;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {

    // Method to read the content of a file using FileInputStream
    public String readFileContent(String filePath) {
        // Initialize a StringBuilder to store the content of the file
        StringBuilder content = new StringBuilder();

        // Open the file using FileInputStream and read its content
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int byteRead;
            // Read file byte by byte
            while ((byteRead = fileInputStream.read()) != -1) {
                // Append each byte as a character to the StringBuilder
                content.append((char) byteRead);
            }
        } catch (IOException e) {
            // Handle any exceptions, e.g., file not found or IO errors
            e.printStackTrace();
        }

        // Return the content of the file as a String
        return content.toString();
    }
}
