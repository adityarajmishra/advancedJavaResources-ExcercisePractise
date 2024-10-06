package com.skillovilla.java_advanced.assignment3.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level3Test {

    private Class<?> stringUtilsClass;
    private Object stringUtilsInstance;

    @BeforeEach
    void setUp() throws Exception {
        // Load the StringUtils class and create an instance using reflection
        stringUtilsClass = Class.forName("com.skillovilla.java_advanced.assignment3.level3.StringUtils");
        stringUtilsInstance = stringUtilsClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testSortStrings() throws Exception {
        // Reflectively get the sortStrings method
        Method sortStringsMethod = stringUtilsClass.getMethod("sortStrings", List.class);

        // Prepare the input
        List<String> strings = Arrays.asList("Banana", "Apple", "Cherry");

        // Invoke the sortStrings method using reflection
        List<String> result = (List<String>) sortStringsMethod.invoke(stringUtilsInstance, strings);

        // Verify the result
        assertEquals(Arrays.asList("Apple", "Banana", "Cherry"), result);
    }

    @Test
    void testConvertToStringLength() throws Exception {
        // Reflectively get the convertToStringLength method
        Method convertToStringLengthMethod = stringUtilsClass.getMethod("convertToStringLength", List.class);

        // Prepare the input
        List<String> strings = Arrays.asList("Apple", "Banana", "Cherry");

        // Invoke the convertToStringLength method using reflection
        List<Integer> result = (List<Integer>) convertToStringLengthMethod.invoke(stringUtilsInstance, strings);

        // Verify the result
        assertEquals(Arrays.asList(5, 6, 6), result);
    }
}
