package com.skillovilla.java_advanced.level6;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CounterThreadTest {

    @Test
    public void testCounterThread() throws Exception {
        // Step 1: Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Step 2: Load the CounterThread class using reflection
        Class<?> counterThreadClass = Class.forName("com.skillovilla.java_advanced.level6.CounterThread");

        // Step 3: Create an instance of CounterThread using reflection
        Object counterThreadInstance = counterThreadClass.getDeclaredConstructor().newInstance();

        // Step 4: Invoke the execute method using reflection
        Method executeMethod = counterThreadClass.getDeclaredMethod("execute");
        executeMethod.invoke(counterThreadInstance);

        // Step 5: Capture the output and verify
        String output = outputStream.toString().trim();

        // Check if the counting happened correctly
        for (int i = 1; i <= 5; i++) {
            assertTrue(output.contains("Count: " + i), "Output should contain 'Count: " + i + "'");
        }

        // Check that the "Counting complete" message is printed last
        assertTrue(output.endsWith("Counting complete"), "Output should end with 'Counting complete'");

        // Restore System.out
        System.setOut(System.out);
    }
}
