package com.skillovilla.java_advanced.level9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResourceFileWriter {

    // Method to write content to a file using CustomResource
    public void writeUsingResource(String filePath, String content) {
        // Create an instance of CustomResource
        try (CustomResource customResource = new CustomResource(filePath)) {
            // Use CustomResource to write the content to the file
            customResource.write(content);
        } catch (IOException e) {
            // Handle IOException (e.g., error writing to file)
            System.out.println("Error writing to file: " + filePath);
            e.printStackTrace();
        }
    }
}

// Hypothetical CustomResource class for demonstration
class CustomResource implements AutoCloseable {
    private BufferedWriter writer;

    public CustomResource(String filePath) throws IOException {
        // Initialize the BufferedWriter to write to the specified file
        writer = new BufferedWriter(new FileWriter(filePath));
    }

    public void write(String content) throws IOException {
        // Write the content to the file
        writer.write(content);
    }

    @Override
    public void close() throws IOException {
        // Close the BufferedWriter resource
        if (writer != null) {
            writer.close();
        }
    }
}
