package com.skillovilla.java_advanced.level1;

import java.io.FileInputStream;
import java.io.IOException;

public class BasicFileReader {

    // Method to read the content of a file using FileInputStream
    public String readFileContent(String filePath) {
        StringBuilder content = new StringBuilder();  // To store the file content

        // Open the file using FileInputStream
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int byteRead;
            // Read the content byte by byte
            while ((byteRead = fileInputStream.read()) != -1) {
                content.append((char) byteRead);  // Convert byte to character and append
            }
        } catch (IOException e) {
            // Handle IOException, return "File not found" if the file does not exist
            return "File not found";
        }

        // Return the content as a String
        return content.toString();
    }
}
