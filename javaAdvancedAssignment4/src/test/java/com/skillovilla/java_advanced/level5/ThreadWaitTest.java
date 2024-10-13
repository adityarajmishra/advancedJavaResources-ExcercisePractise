package com.skillovilla.java_advanced.level5;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadWaitTest {

    @Test
    public void testThreadWait() throws Exception {
        // Step 1: Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Step 2: Load the ThreadWait class using reflection
        Class<?> threadWaitClass = Class.forName("com.skillovilla.java_advanced.level5.ThreadWait");

        // Step 3: Create an instance of ThreadWait using reflection
        Object threadWaitInstance = threadWaitClass.getDeclaredConstructor().newInstance();

        // Step 4: Invoke the execute method using reflection
        Method executeMethod = threadWaitClass.getDeclaredMethod("execute");
        executeMethod.invoke(threadWaitInstance);

        // Step 5: Capture the output and verify
        String output = outputStream.toString().trim();

        // Step 6: Split the output by lines and check order and content
        String[] lines = output.split(System.lineSeparator());

        // There should be exactly two lines of output
        assertEquals(2, lines.length, "Output should contain exactly two lines.");

        // Check the content of each line
        assertEquals("Runnable is waiting", lines[0], "First message should indicate the thread is waiting.");
        assertEquals("Thread has completed execution", lines[1], "Second message should indicate the thread has completed execution.");

        // Restore System.out
        System.setOut(System.out);
    }
}
