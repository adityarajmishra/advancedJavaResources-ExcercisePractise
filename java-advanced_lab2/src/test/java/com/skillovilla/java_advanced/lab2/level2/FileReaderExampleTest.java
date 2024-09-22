package com.skillovilla.java_advanced.lab2.level2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderExampleTest {

    private Class<?> simpleFileReaderClass;
    private Object simpleFileReaderInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        simpleFileReaderClass = Class.forName("com.skillovilla.java_advanced.lab2.level2.FileReaderExample");
        simpleFileReaderInstance = simpleFileReaderClass.getDeclaredConstructor().newInstance();

        // Set the file path to a directory within the "tmp" folder
        testFilePath = Paths.get("tmp", "testfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());

        // Prepare a test file with some content
        try (FileWriter writer = new FileWriter(testFilePath.toFile())) {
            writer.write("Sample content for file reader test.");
        }
    }

    @Test
    void testReadFile() throws Exception {
        Method readFileMethod = simpleFileReaderClass.getMethod("readFile", String.class);

        String content = (String) readFileMethod.invoke(simpleFileReaderInstance, testFilePath.toString());

        assertEquals("Sample content for file reader test.", content);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Delete the test file after the test
        Files.deleteIfExists(testFilePath);

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
