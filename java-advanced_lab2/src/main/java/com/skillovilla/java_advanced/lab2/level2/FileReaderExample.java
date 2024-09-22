package com.skillovilla.java_advanced.lab2.level2;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

    // Method to read the content of a file using FileReader
    public String readFile(String filePath) {
        // Initialize a StringBuilder to store the content of the file
        StringBuilder content = new StringBuilder();

        // Open the file using FileReader and read its content
        try (FileReader fileReader = new FileReader(filePath)) {
            int charRead;
            // Read file character by character
            while ((charRead = fileReader.read()) != -1) {
                // Append each character read to the StringBuilder
                content.append((char) charRead);
            }
        } catch (IOException e) {
            // Handle any exceptions, e.g., file not found or IO errors
            e.printStackTrace();
        }

        // Return the content of the file as a String
        return content.toString();
    }
}
