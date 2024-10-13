package com.skillovilla.java_advanced.level8;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetWorkerTest {

    @Test
    public void testSynchronizedBlock() throws Exception {
        // Step 1: Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Step 2: Load the SharedSet class and create an instance using reflection
        Class<?> sharedSetClass = Class.forName("com.skillovilla.java_advanced.level8.SharedSet");
        Object sharedSetInstance = sharedSetClass.getDeclaredConstructor().newInstance();

        // Step 3: Load the SetWorker class using reflection
        Class<?> setWorkerClass = Class.forName("com.skillovilla.java_advanced.level8.SetWorker");

        // Step 4: Create an instance of SetWorker using reflection
        Constructor<?> setWorkerConstructor = setWorkerClass.getDeclaredConstructor(sharedSetClass);
        Object setWorkerInstance = setWorkerConstructor.newInstance(sharedSetInstance);

        // Step 5: Invoke the execute method using reflection
        Method executeMethod = setWorkerClass.getDeclaredMethod("execute");
        executeMethod.invoke(setWorkerInstance);

        // Step 6: Capture the output and verify that the set size is 100
        String output = outputStream.toString();
        assertTrue(output.contains("Set size: 100"), "Output should indicate that the set size is 100");

        // Restore System.out
        System.setOut(System.out);
    }
}
