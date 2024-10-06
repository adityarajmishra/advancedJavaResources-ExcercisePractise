package com.skillovilla.java_advanced.assignment3.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level2Test {

    private Class<?> operationsClass;
    private Object operationsInstance;

    @BeforeEach
    void setUp() throws Exception {
        // Load the SimpleLambdaOperations class and create an instance using reflection
        operationsClass = Class.forName("com.skillovilla.java_advanced.assignment3.level2.SimpleLambdaOperations");
        operationsInstance = operationsClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testAdd() throws Exception {
        // Reflectively get the add method
        Method addMethod = operationsClass.getMethod("add", int.class, int.class);

        // Invoke the add method using reflection
        int result = (int) addMethod.invoke(operationsInstance, 7, 3);

        // Verify the result
        assertEquals(10, result);
    }

    @Test
    void testSubtract() throws Exception {
        // Reflectively get the subtract method
        Method subtractMethod = operationsClass.getMethod("subtract", int.class, int.class);

        // Invoke the subtract method using reflection
        int result = (int) subtractMethod.invoke(operationsInstance, 7, 3);

        // Verify the result
        assertEquals(4, result);
    }

    @Test
    void testMultiply() throws Exception {
        // Reflectively get the multiply method
        Method multiplyMethod = operationsClass.getMethod("multiply", int.class, int.class);

        // Invoke the multiply method using reflection
        int result = (int) multiplyMethod.invoke(operationsInstance, 7, 3);

        // Verify the result
        assertEquals(21, result);
    }

    @Test
    void testDivide() throws Exception {
        // Reflectively get the divide method
        Method divideMethod = operationsClass.getMethod("divide", int.class, int.class);

        // Test normal division
        int result = (int) divideMethod.invoke(operationsInstance, 6, 3);
        assertEquals(2, result);

        // Test division by zero
        result = (int) divideMethod.invoke(operationsInstance, 6, 0);
        assertEquals(0, result); // Assuming divide method handles division by zero and returns 0
    }
}
