package com.skillovilla.java_advanced.assignment3.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level1Test {

    private Class<?> greetingServiceClass;
    private Object service;

    @BeforeEach
    void setUp() throws Exception {
        // Load the GreetingService class and create an instance using reflection
        greetingServiceClass = Class.forName("com.skillovilla.java_advanced.assignment3.level1.GreetingService");
        service = greetingServiceClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testGreet() throws Exception {
        // Capture the standard output before invoking the method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Reflectively get the greet method
            Method greetMethod = greetingServiceClass.getMethod("greet");

            // Invoke the greet method using reflection
            greetMethod.invoke(service);

            // Verify the output
            assertEquals("Hello World!", outContent.toString().trim());
        } finally {
            // Reset the standard output back to the original
            System.setOut(originalOut);
        }
    }
}
