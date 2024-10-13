package com.skillovilla.java_advanced.level3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AsynchronousTasksTest {

    @Test
    public void testAsynchronousTasksOutput() throws Exception {
        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create an instance of AsynchronousTasks
        Class<?> asyncTasksClass = Class.forName("com.skillovilla.java_advanced.level3.AsynchronousTasks");
        Object asyncTasksInstance = asyncTasksClass.getDeclaredConstructor().newInstance();

        // Invoke the executeTasks method using reflection
        Method executeTasksMethod = asyncTasksClass.getDeclaredMethod("executeTasks");
        executeTasksMethod.invoke(asyncTasksInstance);

        // Verify the output
        String expectedSumOutput = "Sum of first 1000 natural numbers: 500500";
        String expectedSquareSumOutput = "Sum of squares of first 1000 natural numbers: 333833500";
        String output = outputStream.toString().trim();

        assertTrue(output.contains(expectedSumOutput), "The output should contain the sum of the first 1000 natural numbers.");
        assertTrue(output.contains(expectedSquareSumOutput), "The output should contain the sum of squares of the first 1000 natural numbers.");

        // Restore System.out
        System.setOut(System.out);
    }
}
