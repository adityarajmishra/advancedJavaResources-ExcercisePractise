package com.skillovilla.java_advanced.level8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BufferedFileWriterTest {

    private Class<?> bufferedFileWriterClass;
    private Object bufferedFileWriterInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        bufferedFileWriterClass = Class.forName("com.skillovilla.java_advanced.level8.BufferedFileWriter");
        bufferedFileWriterInstance = bufferedFileWriterClass.getDeclaredConstructor().newInstance();

        // Set the file path to a directory within the project (e.g., "tmp")
        testFilePath = Paths.get("tmp", "testfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());
    }

    @Test
    void testWriteToFile() throws Exception {
        // Define the method to be tested
        Method writeToFileMethod = bufferedFileWriterClass.getMethod("writeToFile", String.class, String.class);

        // Define the content to be written to the file
        String content = "This is a test content.";

        // Invoke the method to write content to the file
        writeToFileMethod.invoke(bufferedFileWriterInstance, testFilePath.toString(), content);

        // Verify the content of the file
        String fileContent = Files.readString(testFilePath);
        assertEquals(content, fileContent);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Delete the test file after each test
        if (Files.exists(testFilePath)) {
            Files.delete(testFilePath);
        }

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
