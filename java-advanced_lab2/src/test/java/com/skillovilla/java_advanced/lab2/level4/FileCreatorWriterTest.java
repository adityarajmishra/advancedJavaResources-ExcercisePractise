package com.skillovilla.java_advanced.lab2.level4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileCreatorWriterTest {

    private Class<?> fileCreatorWriterClass;
    private Object fileCreatorWriterInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        fileCreatorWriterClass = Class.forName("com.skillovilla.java_advanced.lab2.level4.FileCreatorWriter");
        fileCreatorWriterInstance = fileCreatorWriterClass.getDeclaredConstructor().newInstance();

        // Set the file path to a directory within the "tmp" folder
        testFilePath = Paths.get("tmp", "testfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());
    }

    @Test
    void testCreateAndWriteFile() throws Exception {
        String content = "This is a test content for file creation and writing.";

        Method createAndWriteFileMethod = fileCreatorWriterClass.getMethod("createAndWriteFile", String.class, String.class);
        createAndWriteFileMethod.invoke(fileCreatorWriterInstance, testFilePath.toString(), content);

        // Verify the file was created
        assertTrue(Files.exists(testFilePath), "The file should be created.");

        // Read the content from the file to verify
        String fileContent = new String(Files.readAllBytes(testFilePath));
        assertEquals(content, fileContent, "The file content should match the provided content.");
    }

    @AfterEach
    void tearDown() throws Exception {
        // Delete the test file after the test
        Files.deleteIfExists(testFilePath);

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
