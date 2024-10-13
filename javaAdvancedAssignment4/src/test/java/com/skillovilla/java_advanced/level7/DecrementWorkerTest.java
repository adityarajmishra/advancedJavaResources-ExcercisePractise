package com.skillovilla.java_advanced.level7;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DecrementWorkerTest {

    @Test
    public void testSynchronizedMethod() throws Exception {
        // Step 1: Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Step 2: Load the DecrementCounter class and create an instance using reflection
        Class<?> counterClass = Class.forName("com.skillovilla.java_advanced.level7.DecrementCounter");
        Object counterInstance = counterClass.getDeclaredConstructor().newInstance();

        // Step 3: Load the DecrementWorker class using reflection
        Class<?> workerClass = Class.forName("com.skillovilla.java_advanced.level7.DecrementWorker");

        // Step 4: Create an instance of DecrementWorker using reflection
        Constructor<?> workerConstructor = workerClass.getDeclaredConstructor(counterClass);
        Object workerInstance = workerConstructor.newInstance(counterInstance);

        // Step 5: Invoke the execute method using reflection
        Method executeMethod = workerClass.getDeclaredMethod("execute");
        executeMethod.invoke(workerInstance);

        // Step 6: Capture the output and verify that the final count is 0
        String output = outputStream.toString();
        assertTrue(output.contains("Final count: 0"), "Output should indicate that the final count is 0");

        // Restore System.out
        System.setOut(System.out);
    }
}
