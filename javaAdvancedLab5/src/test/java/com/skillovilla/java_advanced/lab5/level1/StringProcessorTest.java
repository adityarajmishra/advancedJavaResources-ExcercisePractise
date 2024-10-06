package com.skillovilla.java_advanced.lab5.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {

    private Class<?> stringProcessorClass;
    private Object processor;

    @BeforeEach
    void setUp() throws Exception {
        stringProcessorClass = Class.forName("com.skillovilla.java_advanced.lab5.level1.StringProcessor");
        processor = stringProcessorClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testProcessStringsBasic() throws Exception {
        Method processStringsMethod = stringProcessorClass.getMethod("processStrings", List.class);
        List<String> strings = Arrays.asList("hello", "world", "java");
        List<String> result = (List<String>) processStringsMethod.invoke(processor, strings);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList("HELLO", "WORLD", "JAVA"), result, "Strings should be converted to uppercase");
    }

    @Test
    void testProcessStringsEmptyList() throws Exception {
        Method processStringsMethod = stringProcessorClass.getMethod("processStrings", List.class);
        List<String> strings = Arrays.asList();
        List<String> result = (List<String>) processStringsMethod.invoke(processor, strings);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.isEmpty(), "Result should be an empty list when input is empty");
    }

    @Test
    void testProcessStringsWithMixedCase() throws Exception {
        Method processStringsMethod = stringProcessorClass.getMethod("processStrings", List.class);
        List<String> strings = Arrays.asList("Hello", "WoRLd", "JAVA");
        List<String> result = (List<String>) processStringsMethod.invoke(processor, strings);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList("HELLO", "WORLD", "JAVA"), result, "Strings should be converted to uppercase");
        assertTrue(result.stream().allMatch(s -> s.equals(s.toUpperCase())), "All strings should be in uppercase");
    }

    @Test
    void testProcessStringsWithSpecialCharacters() throws Exception {
        Method processStringsMethod = stringProcessorClass.getMethod("processStrings", List.class);
        List<String> strings = Arrays.asList("hello!", "world@", "java#");
        List<String> result = (List<String>) processStringsMethod.invoke(processor, strings);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList("HELLO!", "WORLD@", "JAVA#"), result, "Special characters should remain unchanged");
        assertTrue(result.stream().allMatch(s -> s.equals(s.toUpperCase())), "All strings should be in uppercase");
    }

    @Test
    void testProcessStringsWithNumbers() throws Exception {
        Method processStringsMethod = stringProcessorClass.getMethod("processStrings", List.class);
        List<String> strings = Arrays.asList("java1", "world2", "hello3");
        List<String> result = (List<String>) processStringsMethod.invoke(processor, strings);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList("JAVA1", "WORLD2", "HELLO3"), result, "Numbers should remain unchanged while letters are converted to uppercase");
    }
}
