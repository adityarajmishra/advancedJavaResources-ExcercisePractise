package com.skillovilla.java_advanced.level4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialCalculator() throws Exception {
        // Step 1: Use reflection to load the FactorialCalculator class
        Class<?> factorialCalculatorClass = Class.forName("com.skillovilla.java_advanced.level4.FactorialCalculator");

        // Step 2: Verify if FactorialCalculator implements Runnable using reflection
        Class<?>[] interfaces = factorialCalculatorClass.getInterfaces();
        boolean implementsRunnable = false;
        for (Class<?> iface : interfaces) {
            if (iface.equals(Runnable.class)) {
                implementsRunnable = true;
                break;
            }
        }
        assertTrue(implementsRunnable, "FactorialCalculator should implement Runnable interface");

        // Step 3: Verify if 'run' method exists using reflection
        Method runMethod = factorialCalculatorClass.getMethod("run");
        assertNotNull(runMethod, "FactorialCalculator should have a 'run' method");

        // Step 4: Use reflection to create an instance of FactorialCalculator with a specific number
        Constructor<?> constructor = factorialCalculatorClass.getConstructor(int.class);
        int testNumber = 5;  // We will calculate the factorial of 5
        Object factorialCalculatorInstance = constructor.newInstance(testNumber);

        // Step 5: Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Step 6: Create and start the thread
        Thread thread = new Thread((Runnable) factorialCalculatorInstance);
        thread.start();
        thread.join();  // Ensure the thread finishes

        // Step 7: Verify the output
        String expectedOutput = "Factorial of 5 is 120";
        assertEquals(expectedOutput, outputStream.toString().trim(), "The output should match the expected factorial result");

        // Restore System.out
        System.setOut(System.out);
    }
}
