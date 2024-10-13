package com.skillovilla.java_advanced.level1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {

    @Test
    public void testRunMethodOutput() throws Exception {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create an instance of ReverseString
        Class<?> reverseStringClass = Class.forName("com.skillovilla.java_advanced.level1.ReverseString");
        Object reverseStringInstance = reverseStringClass.getDeclaredConstructor().newInstance();

        // Get the run method using reflection and invoke it
        Method runMethod = reverseStringClass.getDeclaredMethod("run");
        runMethod.invoke(reverseStringInstance);

        // Add a small delay to ensure the thread completes
        Thread.sleep(100);  // Sleep for a short time to let the thread finish

        // Verify the output
        String expectedOutput = "!dlroW ,olleH";
        assertEquals(expectedOutput, outputStream.toString().trim(), "The output should match the expected reversed string");

        // Restore System.out
        System.setOut(System.out);
    }
}
