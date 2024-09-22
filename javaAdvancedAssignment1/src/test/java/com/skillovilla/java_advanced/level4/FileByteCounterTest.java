package com.skillovilla.java_advanced.level4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileByteCounterTest {

    private FileByteCounter fileByteCounter;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        fileByteCounter = new FileByteCounter();

        // Set the file path to a directory within the "tmp" folder
        testFilePath = Paths.get("tmp", "testfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());

        // Prepare a test file with some content
        try (FileWriter writer = new FileWriter(testFilePath.toFile())) {
            writer.write("This is a test file.");
        }
    }

    @Test
    void testCountBytesInFile() {
        int byteCount = fileByteCounter.countBytesInFile(testFilePath.toString());
        assertEquals(20, byteCount, "The byte count should be 21");
    }

    @AfterEach
    void tearDown() throws IOException {
        // Delete the test file after the test is complete
        Files.deleteIfExists(testFilePath);

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
