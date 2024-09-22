package com.skillovilla.java_advanced.level3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class MultiFileReader {

    // Method to read the content of multiple files and return concatenated content as a single string
    public String readMultipleFiles(List<String> filePaths) {
        // Initialize a StringBuilder to hold the concatenated content
        StringBuilder concatenatedContent = new StringBuilder();

        // Iterate over the file paths provided in the list
        for (String filePath : filePaths) {
            // Use try-with-resources to ensure each FileInputStream is properly closed
            try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                int byteRead;
                // Read the content byte by byte and append to StringBuilder
                while ((byteRead = fileInputStream.read()) != -1) {
                    concatenatedContent.append((char) byteRead);
                }
            } catch (IOException e) {
                // Handle IOException, such as if the file is not found or other IO errors
                System.out.println("Error reading file: " + filePath);
                e.printStackTrace();
            }
        }

        // Return the concatenated content without any extra newline or separator
        return concatenatedContent.toString();
    }
}
