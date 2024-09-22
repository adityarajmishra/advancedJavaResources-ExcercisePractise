package com.skillovilla.java_advanced.level6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileContentWriterTest {

    private Class<?> fileContentWriterClass;
    private Object fileContentWriterInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        fileContentWriterClass = Class.forName("com.skillovilla.java_advanced.level6.FileContentWriter");
        fileContentWriterInstance = fileContentWriterClass.getDeclaredConstructor().newInstance();
        testFilePath = Paths.get("tmp", "outputfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());
    }

    @Test
    void testWriteContentToFile() throws Exception {
        String content = "This is a test content";

        // Use reflection to invoke the writeContentToFile method
        Method writeContentToFileMethod = fileContentWriterClass.getMethod("writeContentToFile", String.class, String.class);
        writeContentToFileMethod.invoke(fileContentWriterInstance, content, testFilePath.toString());

        // Read the content from the file to verify
        String fileContent = new String(Files.readAllBytes(testFilePath));
        assertEquals(content, fileContent);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Delete the test file if it exists
        if (Files.exists(testFilePath)) {
            Files.delete(testFilePath);
        }

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
