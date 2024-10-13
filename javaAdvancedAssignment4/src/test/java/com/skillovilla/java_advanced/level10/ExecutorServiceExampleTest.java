package com.skillovilla.java_advanced.level10;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExecutorServiceExampleTest {

    @Test
    public void testExecutorServiceOutput() throws Exception {
        // Step 1: Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Step 2: Load the ExecutorServiceExample class using reflection
        Class<?> exampleClass = Class.forName("com.skillovilla.java_advanced.level10.ExecutorServiceExample");

        // Step 3: Create an instance of ExecutorServiceExample using reflection
        Object exampleInstance = exampleClass.getDeclaredConstructor().newInstance();

        // Step 4: Invoke the executeTasks method using reflection
        Method executeTasksMethod = exampleClass.getDeclaredMethod("executeTasks");
        executeTasksMethod.invoke(exampleInstance);

        // Adding a small delay to ensure all threads complete
        Thread.sleep(1000);  // Wait time adjusted to ensure all tasks are completed

        // Step 5: Verify the output
        String output = outputStream.toString().trim();

        // Check that output contains expected task messages
        for (int i = 1; i <= 5; i++) {
            assertTrue(output.contains("Task-" + i), "Task-" + i + " not found in output.");
        }

        // Check that each task was executed by a thread in the pool
        assertTrue(output.contains("pool-1-thread-"), "Tasks were not executed by threads in the pool.");

        // Restore System.out
        System.setOut(System.out);
    }
}
