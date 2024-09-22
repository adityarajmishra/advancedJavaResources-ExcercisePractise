package com.skillovilla.java_advanced.level9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResourceFileWriterTest {

    private Class<?> resourceFileWriterClass;
    private Object resourceFileWriterInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        resourceFileWriterClass = Class.forName("com.skillovilla.java_advanced.level9.ResourceFileWriter");
        resourceFileWriterInstance = resourceFileWriterClass.getDeclaredConstructor().newInstance();

        testFilePath = Paths.get("tmp", "testfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());
    }

    @Test
    void testWriteUsingResource() throws Exception {
        String content = "This is a test content.";

        // Use reflection to get the writeUsingResource method
        Method writeUsingResourceMethod = resourceFileWriterClass.getMethod("writeUsingResource", String.class, String.class);

        // Invoke the method using reflection
        writeUsingResourceMethod.invoke(resourceFileWriterInstance, testFilePath.toString(), content);

        // Verify the content of the file
        String fileContent = new String(Files.readAllBytes(testFilePath));
        assertEquals(content, fileContent);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Delete the test file after test
        if (Files.exists(testFilePath)) {
            Files.delete(testFilePath);
        }

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
