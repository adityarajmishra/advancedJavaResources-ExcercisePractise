package com.skillovilla.java_advanced.lab2.level3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileWriterExampleTest {

    private Class<?> simpleFileWriterClass;
    private Object simpleFileWriterInstance;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws Exception {
        simpleFileWriterClass = Class.forName("com.skillovilla.java_advanced.lab2.level3.FileWriterExample");
        simpleFileWriterInstance = simpleFileWriterClass.getDeclaredConstructor().newInstance();
        testFilePath = Paths.get("tmp", "outputfile.txt");

        // Create directories if they do not exist
        Files.createDirectories(testFilePath.getParent());
    }

    @Test
    void testWriteContentToFile() throws Exception {
        String content = "This is a test content";

        Method writeContentToFileMethod = simpleFileWriterClass.getMethod("writeContentToFile", String.class, String.class);
        writeContentToFileMethod.invoke(simpleFileWriterInstance, content, testFilePath.toString());

        // Read the content from the file to verify
        String fileContent = new String(Files.readAllBytes(testFilePath));
        assertEquals(content, fileContent);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Delete the test file after the test
        Files.deleteIfExists(testFilePath);

        // Optional: Delete the tmp directory if it's empty
        Files.deleteIfExists(testFilePath.getParent());
    }
}
