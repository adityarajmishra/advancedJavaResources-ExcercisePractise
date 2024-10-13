package com.skillovilla.java_advanced.lab7.level1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringProcessorTest {

    @Test
    public void testStringProcessingWithMultipleOperations() throws Exception {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Use reflection to create an instance of StringProcessor with "Hello, World!"
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level1.StringProcessor");
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Runnable processorTask1 = (Runnable) constructor.newInstance("Hello, World!");

        // Start the thread and invoke run() method using reflection
        Thread thread1 = new Thread(processorTask1);
        thread1.start();
        thread1.join(); // Wait for the thread to finish

        // Capture the actual output
        String actualOutput1 = outputStream.toString().trim().replaceAll("\\r", "");

        // Expected output
        String expectedOutput1 = "Reversed String: !dlroW ,olleH\nNumber of Vowels: 3\nNumber of Words: 2";

        // Debugging info
        System.out.println("Expected:\n" + expectedOutput1);
        System.out.println("Actual:\n" + actualOutput1);

        // Verify the output
        assertEquals(expectedOutput1, actualOutput1, "The output should match the expected processed string for 'Hello, World!'");

        // Restore System.out
        System.setOut(System.out);
    }

    @Test
    public void testStringProcessingWithSingleCharacter() throws Exception {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Use reflection to create an instance of StringProcessor with a single character "A"
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level1.StringProcessor");
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Runnable processorTask1 = (Runnable) constructor.newInstance("A");

        // Start the thread and invoke run() method using reflection
        Thread thread1 = new Thread(processorTask1);
        thread1.start();
        thread1.join(); // Wait for the thread to finish

        // Capture the actual output for the single character
        String actualOutput1 = outputStream.toString().trim().replaceAll("\\r", "");

        // Expected output
        String expectedOutput1 = "Reversed String: A\nNumber of Vowels: 1\nNumber of Words: 1";

        // Verify the output
        assertEquals(expectedOutput1, actualOutput1, "The output should match the expected processed string for a single character 'A'");

        // Restore System.out
        System.setOut(System.out);
    }



    @Test
    public void testStringProcessingWithNumbers() throws Exception {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Use reflection to create an instance of StringProcessor with "12345"
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level1.StringProcessor");
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Runnable processorTask1 = (Runnable) constructor.newInstance("12345");

        // Start the thread and invoke run() method using reflection
        Thread thread1 = new Thread(processorTask1);
        thread1.start();
        thread1.join(); // Wait for the thread to finish

        // Capture the actual output for the string with numbers
        String actualOutput1 = outputStream.toString().trim().replaceAll("\\r", "");

        // Expected output
        String expectedOutput1 = "Reversed String: 54321\nNumber of Vowels: 0\nNumber of Words: 1";

        // Verify the output
        assertEquals(expectedOutput1, actualOutput1, "The output should match the expected processed string for the string '12345'");

        // Restore System.out
        System.setOut(System.out);
    }

    @Test
    public void testStringProcessingWithMixedCharacters() throws Exception {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Use reflection to create an instance of StringProcessor with "Java123!@#"
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level1.StringProcessor");
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Runnable processorTask1 = (Runnable) constructor.newInstance("Java123!@#");

        // Start the thread and invoke run() method using reflection
        Thread thread1 = new Thread(processorTask1);
        thread1.start();
        thread1.join(); // Wait for the thread to finish

        // Capture the actual output for the string with mixed characters
        String actualOutput1 = outputStream.toString().trim().replaceAll("\\r", "");

        // Expected output
        String expectedOutput1 = "Reversed String: #@!321avaJ\nNumber of Vowels: 2\nNumber of Words: 1";

        // Verify the output
        assertEquals(expectedOutput1, actualOutput1, "The output should match the expected processed string for the string 'Java123!@#'");

        // Restore System.out
        System.setOut(System.out);
    }

    @Test
    public void testStringProcessingWithUnicodeCharacters() throws Exception {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Use reflection to create an instance of StringProcessor with "こんにちは"
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level1.StringProcessor");
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Runnable processorTask1 = (Runnable) constructor.newInstance("こんにちは");

        // Start the thread and invoke run() method using reflection
        Thread thread1 = new Thread(processorTask1);
        thread1.start();
        thread1.join(); // Wait for the thread to finish

        // Capture the actual output for the string with Unicode characters
        String actualOutput1 = outputStream.toString().trim().replaceAll("\\r", "");

        // Expected output (Japanese "Hello" reversed)
        String expectedOutput1 = "Reversed String: はちにんこ\nNumber of Vowels: 0\nNumber of Words: 1";

        // Verify the output
        assertEquals(expectedOutput1, actualOutput1, "The output should match the expected processed string for the Unicode string 'こんにちは'");

        // Restore System.out
        System.setOut(System.out);
    }

    @Test
    public void testStringProcessingWithLongString() throws Exception {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create a long string
        String longString = "a".repeat(1000);

        // Use reflection to create an instance of StringProcessor with the long string
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level1.StringProcessor");
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Runnable processorTask1 = (Runnable) constructor.newInstance(longString);

        // Start the thread and invoke run() method using reflection
        Thread thread1 = new Thread(processorTask1);
        thread1.start();
        thread1.join(); // Wait for the thread to finish

        // Capture the actual output for the long string
        String actualOutput1 = outputStream.toString().trim().replaceAll("\\r", "");

        // Expected output (reversed long string)
        String expectedOutput1 = "Reversed String: " + "a".repeat(1000) + "\nNumber of Vowels: 1000\nNumber of Words: 1";

        // Verify the output
        assertEquals(expectedOutput1, actualOutput1, "The output should match the expected processed string for the long string.");

        // Restore System.out
        System.setOut(System.out);
    }
}

