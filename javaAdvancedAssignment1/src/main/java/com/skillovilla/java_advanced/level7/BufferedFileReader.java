package com.skillovilla.java_advanced.level7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReader {

    // Method to read the entire content of a file and return it as a single string
    public String readFileContent(String filePath) {
        StringBuilder content = new StringBuilder();

        // Open the file using BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read the content line by line and concatenate into a single string
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append(System.lineSeparator()); // Append line and new line
            }
        } catch (IOException e) {
            // Handle IOException (e.g., file not found or unable to read)
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
        }

        return content.toString().trim(); // Do not change this line
    }
}
