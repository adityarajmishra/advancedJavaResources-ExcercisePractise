package com.skillovilla.java_advanced.level5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileContentReaderTest {

    private Class<?> fileContentReaderClass;
    private Object fileContentReaderInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        fileContentReaderClass = Class.forName("com.skillovilla.java_advanced.level5.FileContentReader");
        fileContentReaderInstance = fileContentReaderClass.getDeclaredConstructor().newInstance();

        // Set the file path to a directory within the project (e.g., "tmp")
        testFilePath = Paths.get("tmp", "testfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());

        // Prepare a test file with some content
        try (FileWriter writer = new FileWriter(testFilePath.toFile())) {
            writer.write("Sample file content for testing.");
        }
    }

    @Test
    void testReadFileContent() throws Exception {
        Method readFileContentMethod = fileContentReaderClass.getMethod("readFileContent", String.class);

        String content = (String) readFileContentMethod.invoke(fileContentReaderInstance, testFilePath.toString());

        assertEquals("Sample file content for testing.", content);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Delete the test file after the test
        Files.deleteIfExists(testFilePath);

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
