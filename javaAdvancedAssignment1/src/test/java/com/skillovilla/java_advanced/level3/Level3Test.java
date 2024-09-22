package com.skillovilla.java_advanced.level3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level3Test {

    private Class<?> multiFileReaderClass;
    private Object multiFileReaderInstance;
    private Path testFilePath1;
    private Path testFilePath2;
    private Path testFilePath3;

    @BeforeEach
    void setUp() throws Exception {
        multiFileReaderClass = Class.forName("com.skillovilla.java_advanced.level3.MultiFileReader");
        multiFileReaderInstance = multiFileReaderClass.getDeclaredConstructor().newInstance();

        // Set the file paths to directories within the project (e.g., "tmp")
        testFilePath1 = Paths.get("tmp", "file1.txt");
        testFilePath2 = Paths.get("tmp", "file2.txt");
        testFilePath3 = Paths.get("tmp", "file3.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath1.getParent());

        // Prepare test files with some content
        try (FileWriter writer1 = new FileWriter(testFilePath1.toFile())) {
            writer1.write("Content of file 1.");
        }
        try (FileWriter writer2 = new FileWriter(testFilePath2.toFile())) {
            writer2.write("Content of file 2.");
        }
        try (FileWriter writer3 = new FileWriter(testFilePath3.toFile())) {
            writer3.write("Content of file 3.");
        }
    }

    @Test
    void testReadMultipleFiles() throws Exception {
        Method readMultipleFilesMethod = multiFileReaderClass.getMethod("readMultipleFiles", List.class);

        String concatenatedContent = (String) readMultipleFilesMethod.invoke(multiFileReaderInstance,
                Arrays.asList(testFilePath1.toString(), testFilePath2.toString(), testFilePath3.toString()));

        String expectedContent = "Content of file 1.Content of file 2.Content of file 3.";
        assertEquals(expectedContent, concatenatedContent, "The concatenated content should match the expected content.");
    }

    @AfterEach
    void tearDown() throws Exception {
        // Clean up the test files if they still exist
        Files.deleteIfExists(testFilePath1);
        Files.deleteIfExists(testFilePath2);
        Files.deleteIfExists(testFilePath3);
        Files.deleteIfExists(testFilePath1.getParent());
    }
}
