package com.skillovilla.java_advanced.assignment3.level5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level5Test {

    private Class<?> dataTransformerClass;
    private Object dataTransformerInstance;

    @BeforeEach
    void setUp() throws Exception {
        dataTransformerClass = Class.forName("com.skillovilla.java_advanced.assignment3.level5.DataTransformer");
        dataTransformerInstance = dataTransformerClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testFilterAndTransform() throws Exception {
        Method filterAndTransformMethod = dataTransformerClass.getMethod("filterAndTransform", List.class);
        List<String> data = Arrays.asList("apple", "banana", "cherry", "date", "fig");
        List<String> result = (List<String>) filterAndTransformMethod.invoke(dataTransformerInstance, data);
        assertEquals(Arrays.asList("BANANA", "FIG"), result);
    }

    @Test
    void testSquareEvenNumbers() throws Exception {
        Method squareEvenNumbersMethod = dataTransformerClass.getMethod("squareEvenNumbers", List.class);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = (List<Integer>) squareEvenNumbersMethod.invoke(dataTransformerInstance, numbers);
        assertEquals(Arrays.asList(4, 16, 36), result);
    }
}
