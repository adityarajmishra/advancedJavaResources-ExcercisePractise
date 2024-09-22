package com.skillovilla.java_advanced.level2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Level2Test {

    private Class<?> basicFileWriterClass;
    private Object basicFileWriterInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        basicFileWriterClass = Class.forName("com.skillovilla.java_advanced.level2.BasicFileWriter");
        basicFileWriterInstance = basicFileWriterClass.getDeclaredConstructor().newInstance();

        // Set the file path to a directory within the project (e.g., "tmp")
        testFilePath = Paths.get("tmp", "testfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());
    }

    @Test
    void testWriteToFile() throws Exception {
        Method writeToFileMethod = basicFileWriterClass.getMethod("writeToFile", String.class, String.class);

        String content = "This is a test content.";
        writeToFileMethod.invoke(basicFileWriterInstance, testFilePath.toString(), content);

        assertTrue(Files.exists(testFilePath), "The file should be created.");
        String writtenContent = Files.readString(testFilePath);
        assertEquals(content, writtenContent, "The content written to the file should match the expected content.");
    }

    @AfterEach
    void tearDown() throws Exception {
        // Delete the test file after the test is completed
        Files.deleteIfExists(testFilePath);

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
