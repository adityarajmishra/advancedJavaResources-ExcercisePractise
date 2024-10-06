package com.skillovilla.java_advanced.lab3.level1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {

    // Test StringFormatter using reflection
    @Test
    public void testStringFormatterWithReflection() throws Exception {
        // Load the StringFormatter class and create an instance using reflection
        Class<?> stringFormatterClass = Class.forName("com.skillovilla.java_advanced.lab3.level1.StringFormatter");
        Object stringFormatterInstance = stringFormatterClass.getDeclaredConstructor().newInstance();

        // Get the 'format' method using reflection
        Method formatMethod = stringFormatterClass.getDeclaredMethod("format", String.class);

        // Test the format method using reflection with a lowercase string
        String input = "hello";
        String expectedOutput = "Formatter String: HELLO";
        String actualOutput = (String) formatMethod.invoke(stringFormatterInstance, input);
        assertEquals(expectedOutput, actualOutput, "The string should be converted to uppercase and formatted correctly.");

        // Test the format method using reflection with an already uppercase string
        input = "WORLD";
        expectedOutput = "Formatter String: WORLD";
        actualOutput = (String) formatMethod.invoke(stringFormatterInstance, input);
        assertEquals(expectedOutput, actualOutput, "An uppercase string should remain unchanged but formatted correctly.");

        // Test the format method using reflection with an empty string
        input = "";
        expectedOutput = "Formatter String: ";
        actualOutput = (String) formatMethod.invoke(stringFormatterInstance, input);
        assertEquals(expectedOutput, actualOutput, "Empty string should be formatted correctly.");
    }

    // Test IntegerFormatter using reflection
    @Test
    public void testIntegerFormatterWithReflection() throws Exception {
        // Load the IntegerFormatter class and create an instance using reflection
        Class<?> integerFormatterClass = Class.forName("com.skillovilla.java_advanced.lab3.level1.IntegerFormatter");
        Object integerFormatterInstance = integerFormatterClass.getDeclaredConstructor().newInstance();

        // Get the 'format' method using reflection
        Method formatMethod = integerFormatterClass.getDeclaredMethod("format", Integer.class);

        // Test the format method using reflection with an even number
        int input = 42;
        String expectedOutput = "Formatted Integer: 42 - This is an even number";
        String actualOutput = (String) formatMethod.invoke(integerFormatterInstance, input);
        assertEquals(expectedOutput, actualOutput, "Even number should be identified and formatted correctly.");

        // Test the format method using reflection with an odd number
        input = 33;
        expectedOutput = "Formatted Integer: 33 - This is an odd number";
        actualOutput = (String) formatMethod.invoke(integerFormatterInstance, input);
        assertEquals(expectedOutput, actualOutput, "Odd number should be identified and formatted correctly.");

        // Test the format method using reflection with zero (which is even)
        input = 0;
        expectedOutput = "Formatted Integer: 0 - This is an even number";
        actualOutput = (String) formatMethod.invoke(integerFormatterInstance, input);
        assertEquals(expectedOutput, actualOutput, "Zero should be identified as an even number and formatted correctly.");
    }
}