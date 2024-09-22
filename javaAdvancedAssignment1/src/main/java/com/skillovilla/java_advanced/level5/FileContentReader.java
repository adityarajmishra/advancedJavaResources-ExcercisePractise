package com.skillovilla.java_advanced.level5;

import java.io.FileReader;
import java.io.IOException;

public class FileContentReader {

    // Method to read the content of a file character by character
    public String readFileContent(String filePath) {
        // Initialize a StringBuilder to store file content
        StringBuilder content = new StringBuilder();

        // Open the file using FileReader
        try (FileReader fileReader = new FileReader(filePath)) {
            int character;
            // Read character by character from the file
            while ((character = fileReader.read()) != -1) {
                // Append each character to the StringBuilder
                content.append((char) character);
            }
        } catch (IOException e) {
            // Handle IOException (e.g., file not found or unable to read)
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
        }

        // Return the content as a string
        return content.toString();
    }
}
