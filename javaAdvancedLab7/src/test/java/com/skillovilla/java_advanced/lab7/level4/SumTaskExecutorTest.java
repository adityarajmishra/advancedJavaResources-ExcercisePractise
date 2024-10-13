package com.skillovilla.java_advanced.lab7.level4;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTaskExecutorTest {

    @Test
    public void testSumTaskForPositiveNumber() throws Exception {
        // Use reflection to create an instance of SumTaskExecutor
        Class<?> executorClass = Class.forName("com.skillovilla.java_advanced.lab7.level4.SumTaskExecutor");
        Constructor<?> executorConstructor = executorClass.getConstructor();
        Object executor = executorConstructor.newInstance();

        // Use reflection to execute the sum task with a positive number
        Method executeSumTaskMethod = executorClass.getMethod("executeSumTask", int.class);
        int result = (int) executeSumTaskMethod.invoke(executor, 10);

        // Verify the result
        assertEquals(55, result, "Sum of numbers from 1 to 10 should be 55.");
    }

    @Test
    public void testSumTaskForZero() throws Exception {
        // Use reflection to create an instance of SumTaskExecutor
        Class<?> executorClass = Class.forName("com.skillovilla.java_advanced.lab7.level4.SumTaskExecutor");
        Constructor<?> executorConstructor = executorClass.getConstructor();
        Object executor = executorConstructor.newInstance();

        // Use reflection to execute the sum task with zero
        Method executeSumTaskMethod = executorClass.getMethod("executeSumTask", int.class);
        int result = (int) executeSumTaskMethod.invoke(executor, 0);

        // Verify the result
        assertEquals(0, result, "Sum of numbers from 1 to 0 should be 0.");
    }

    @Test
    public void testSumTaskForLargeNumber() throws Exception {
        // Use reflection to create an instance of SumTaskExecutor
        Class<?> executorClass = Class.forName("com.skillovilla.java_advanced.lab7.level4.SumTaskExecutor");
        Constructor<?> executorConstructor = executorClass.getConstructor();
        Object executor = executorConstructor.newInstance();

        // Use reflection to execute the sum task with a large number
        Method executeSumTaskMethod = executorClass.getMethod("executeSumTask", int.class);
        int result = (int) executeSumTaskMethod.invoke(executor, 100);

        // Verify the result
        assertEquals(5050, result, "Sum of numbers from 1 to 100 should be 5050.");
    }

    @Test
    public void testSumTaskForNegativeNumber() throws Exception {
        // Use reflection to create an instance of SumTaskExecutor
        Class<?> executorClass = Class.forName("com.skillovilla.java_advanced.lab7.level4.SumTaskExecutor");
        Constructor<?> executorConstructor = executorClass.getConstructor();
        Object executor = executorConstructor.newInstance();

        // Use reflection to execute the sum task with a negative number
        Method executeSumTaskMethod = executorClass.getMethod("executeSumTask", int.class);
        int result = (int) executeSumTaskMethod.invoke(executor, -10);

        // Verify the result
        assertEquals(0, result, "Sum of numbers from 1 to a negative number should be 0.");
    }
}
