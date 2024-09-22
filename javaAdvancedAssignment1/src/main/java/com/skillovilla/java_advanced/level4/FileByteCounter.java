package com.skillovilla.java_advanced.level4;

import java.io.FileInputStream;
import java.io.IOException;

public class FileByteCounter {

    // Method to count the number of bytes in a file
    public int countBytesInFile(String filePath) {
        // Initialize the byte count
        int byteCount = 0;

        // Open the file using FileInputStream
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            // Read bytes until the end of the file
            while (fileInputStream.read() != -1) {
                byteCount++; // Increment byte count for each byte read
            }
        } catch (IOException e) {
            // Handle IOException (e.g., file not found or unable to read)
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
        }

        // Return the total byte count
        return byteCount;
    }
}
