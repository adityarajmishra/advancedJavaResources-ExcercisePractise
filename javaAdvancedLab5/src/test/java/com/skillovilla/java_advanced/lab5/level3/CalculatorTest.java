package com.skillovilla.java_advanced.lab5.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Class<?> calculatorClass;
    private Object calculator;

    @BeforeEach
    void setUp() throws Exception {
        calculatorClass = Class.forName("com.skillovilla.java_advanced.lab5.level3.Calculator");
        calculator = calculatorClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testAddition() throws Exception {
        // Reflectively test the add method
        Method addMethod = calculatorClass.getDeclaredMethod("add", int.class, int.class);
        int result = (int) addMethod.invoke(calculator, 7, 3);

        assertNotNull(addMethod, "Method add should exist");
        assertEquals(10, result, "Addition of 7 and 3 should be 10");
    }

    @Test
    void testSubtraction() throws Exception {
        // Reflectively test the subtract method
        Method subtractMethod = calculatorClass.getDeclaredMethod("subtract", int.class, int.class);
        int result = (int) subtractMethod.invoke(calculator, 7, 3);

        assertNotNull(subtractMethod, "Method subtract should exist");
        assertEquals(4, result, "Subtraction of 7 and 3 should be 4");
    }

    @Test
    void testMultiplication() throws Exception {
        // Reflectively test the multiply method
        Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);
        int result = (int) multiplyMethod.invoke(calculator, 7, 3);

        assertNotNull(multiplyMethod, "Method multiply should exist");
        assertEquals(21, result, "Multiplication of 7 and 3 should be 21");
    }

    @Test
    void testDivision() throws Exception {
        // Reflectively test the divide method
        Method divideMethod = calculatorClass.getDeclaredMethod("divide", int.class, int.class);

        // Test valid division
        int result = (int) divideMethod.invoke(calculator, 6, 3);
        assertNotNull(divideMethod, "Method divide should exist");
        assertEquals(2, result, "Division of 6 by 3 should be 2");

        // Test division by zero handling
        try {
            result = (int) divideMethod.invoke(calculator, 6, 0);
            assertEquals(0, result, "Division by zero should return 0");
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (cause instanceof ArithmeticException) {
                assertEquals("/ by zero", cause.getMessage(), "Division by zero should throw ArithmeticException");
            } else {
                throw e;
            }
        }
    }
}
