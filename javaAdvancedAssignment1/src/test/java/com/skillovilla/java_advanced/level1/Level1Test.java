package com.skillovilla.java_advanced.level1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level1Test {

    private Class<?> basicFileReaderClass;
    private Object basicFileReaderInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        basicFileReaderClass = Class.forName("com.skillovilla.java_advanced.level1.BasicFileReader");
        basicFileReaderInstance = basicFileReaderClass.getDeclaredConstructor().newInstance();

        // Set the file path to a directory within the project (e.g., "tmp")
        testFilePath = Paths.get("tmp", "testfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());

        // Prepare a test file with some content
        try (FileWriter writer = new FileWriter(testFilePath.toFile())) {
            writer.write("This is to test FileInputStream logic");
        }
    }

    @Test
    void testReadFileContent() throws Exception {
        Method readFileContentMethod = basicFileReaderClass.getMethod("readFileContent", String.class);

        String content = (String) readFileContentMethod.invoke(basicFileReaderInstance, testFilePath.toString());

        assertEquals("This is to test FileInputStream logic", content);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Delete the test file after the test is completed
        Files.deleteIfExists(testFilePath);

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
