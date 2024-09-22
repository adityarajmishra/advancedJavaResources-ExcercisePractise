package com.skillovilla.java_advanced.level7;

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

class BufferedFileReaderTest {

    private Class<?> bufferedFileReaderClass;
    private Object bufferedFileReaderInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        bufferedFileReaderClass = Class.forName("com.skillovilla.java_advanced.level7.BufferedFileReader");
        bufferedFileReaderInstance = bufferedFileReaderClass.getDeclaredConstructor().newInstance();

        // Set the file path to a directory within the project (e.g., "tmp")
        testFilePath = Paths.get("tmp", "samplefile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());

        // Prepare a test file with some content
        try (FileWriter writer = new FileWriter(testFilePath.toFile())) {
            writer.write("Hello, world!\nThis is a test file.");
        }
    }

    @Test
    void testReadFileContent() throws Exception {
        Method readFileContentMethod = bufferedFileReaderClass.getMethod("readFileContent", String.class);

        String content = (String) readFileContentMethod.invoke(bufferedFileReaderInstance, testFilePath.toString());

        assertEquals("Hello, world!\nThis is a test file.", content);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Delete the test file after the test
        Files.deleteIfExists(testFilePath);

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
