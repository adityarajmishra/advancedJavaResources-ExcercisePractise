package com.skillovilla.java_advanced.level9;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactorialTaskTest {

    @Test
    public void testCallableWithExecutorService() throws Exception {
        // Step 1: Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Step 2: Load the FactorialTask class using reflection
        Class<?> factorialTaskClass = Class.forName("com.skillovilla.java_advanced.level9.FactorialTask");

        // Step 3: Create an instance of FactorialTask using reflection
        Constructor<?> factorialTaskConstructor = factorialTaskClass.getDeclaredConstructor(int.class);
        Object factorialTaskInstance = factorialTaskConstructor.newInstance(0);  // The initial number doesn't matter for this test

        // Step 4: Invoke the executeTasks method using reflection
        Method executeTasksMethod = factorialTaskClass.getDeclaredMethod("executeTasks");
        List<Long> results = (List<Long>) executeTasksMethod.invoke(factorialTaskInstance);

        // Step 5: Verify the results
        assertEquals(5, results.size(), "There should be 5 results");
        assertTrue(results.contains(6L), "The factorial of 3 should be calculated");
        assertTrue(results.contains(720L), "The factorial of 6 should be calculated");

        // Step 6: Verify the output
        String output = outputStream.toString();
        assertTrue(output.contains("Factorial of"), "Output should indicate that factorials were calculated");

        // Restore System.out
        System.setOut(System.out);
    }
}
