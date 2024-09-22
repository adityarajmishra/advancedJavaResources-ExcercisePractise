package com.skillovilla.java_advanced.level10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileManagerTest {

    private Class<?> fileManagerClass;
    private Object fileManagerInstance;
    private Path sourceFilePath;
    private Path destinationFilePath;

    @BeforeEach
    void setUp() throws Exception {
        fileManagerClass = Class.forName("com.skillovilla.java_advanced.level10.FileManager");
        fileManagerInstance = fileManagerClass.getDeclaredConstructor().newInstance();

        sourceFilePath = Paths.get("tmp", "source.txt");
        destinationFilePath = Paths.get("tmp", "destination", "dest.txt");

        // Create directories if they do not exist
        Files.createDirectories(sourceFilePath.getParent());

        // Prepare a source file with some content
        Files.write(sourceFilePath, "This is test content.".getBytes());
    }

    @Test
    void testCopyFile() throws Exception {
        Method copyFileMethod = fileManagerClass.getMethod("copyFile", String.class, String.class);

        // Invoke the method
        copyFileMethod.invoke(fileManagerInstance, sourceFilePath.toString(), destinationFilePath.toString());

        // Verify that the destination file was created
        assertTrue(Files.exists(destinationFilePath), "Destination file should exist after copying.");
    }

    @Test
    void testDeleteFile() throws Exception {
        // Define the method to be tested
        Method deleteFileMethod = fileManagerClass.getMethod("deleteFile", String.class);

        // First copy the file so it exists
        Method copyFileMethod = fileManagerClass.getMethod("copyFile", String.class, String.class);
        copyFileMethod.invoke(fileManagerInstance, sourceFilePath.toString(), destinationFilePath.toString());

        // Invoke the method to delete the file
        deleteFileMethod.invoke(fileManagerInstance, destinationFilePath.toString());

        // Verify that the destination file does not exist
        assertTrue(Files.notExists(destinationFilePath), "Destination file should not exist after delete operation.");
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up by deleting the source and destination files if they exist
        Files.deleteIfExists(sourceFilePath);
        Files.deleteIfExists(destinationFilePath);

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(destinationFilePath.getParent());
        Files.deleteIfExists(sourceFilePath.getParent());
    }
}
