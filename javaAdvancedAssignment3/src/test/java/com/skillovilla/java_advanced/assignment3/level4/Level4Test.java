package com.skillovilla.java_advanced.assignment3.level4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level4Test {

    private Class<?> streamExamplesClass;
    private Object streamExamplesInstance;

    @BeforeEach
    void setUp() throws Exception {
        streamExamplesClass = Class.forName("com.skillovilla.java_advanced.assignment3.level4.StreamExamples");
        streamExamplesInstance = streamExamplesClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testFilterAndSortStrings() throws Exception {
        Method filterAndSortStringsMethod = streamExamplesClass.getMethod("filterAndSortStrings", List.class);
        List<String> strings = Arrays.asList("apple", "kiwi", "pear", "a", "be");
        List<String> result = (List<String>) filterAndSortStringsMethod.invoke(streamExamplesInstance, strings);
        assertEquals(Arrays.asList("apple", "kiwi", "pear"), result);
    }

    @Test
    void testSumOfLengths() throws Exception {
        Method sumOfLengthsMethod = streamExamplesClass.getMethod("sumOfLengths", List.class);
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        int result = (int) sumOfLengthsMethod.invoke(streamExamplesInstance, strings);
        assertEquals(17, result);
    }
}
