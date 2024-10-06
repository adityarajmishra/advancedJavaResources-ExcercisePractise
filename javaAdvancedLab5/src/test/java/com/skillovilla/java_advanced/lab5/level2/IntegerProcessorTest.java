package com.skillovilla.java_advanced.lab5.level2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerProcessorTest {

    private Class<?> integerProcessorClass;
    private Object processor;

    @BeforeEach
    void setUp() throws Exception {
        integerProcessorClass = Class.forName("com.skillovilla.java_advanced.lab5.level2.IntegerProcessor");
        processor = integerProcessorClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testSortIntegersBasic() throws Exception {
        Method sortIntegersMethod = integerProcessorClass.getDeclaredMethod("sortIntegers", List.class);
        List<Integer> numbers = Arrays.asList(5, 2, 3, 1, 4);
        List<Integer> result = (List<Integer>) sortIntegersMethod.invoke(processor, numbers);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result, "Numbers should be sorted in ascending order");
    }

    @Test
    void testSortIntegersEmptyList() throws Exception {
        Method sortIntegersMethod = integerProcessorClass.getDeclaredMethod("sortIntegers", List.class);
        List<Integer> numbers = Collections.emptyList();
        List<Integer> result = (List<Integer>) sortIntegersMethod.invoke(processor, numbers);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.isEmpty(), "Result should be an empty list when input is empty");
    }

    @Test
    void testSortIntegersAlreadySorted() throws Exception {
        Method sortIntegersMethod = integerProcessorClass.getDeclaredMethod("sortIntegers", List.class);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = (List<Integer>) sortIntegersMethod.invoke(processor, numbers);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result, "Already sorted list should remain unchanged");
    }

    @Test
    void testSortIntegersWithDuplicates() throws Exception {
        Method sortIntegersMethod = integerProcessorClass.getDeclaredMethod("sortIntegers", List.class);
        List<Integer> numbers = Arrays.asList(3, 1, 2, 3, 4, 2);
        List<Integer> result = (List<Integer>) sortIntegersMethod.invoke(processor, numbers);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList(1, 2, 2, 3, 3, 4), result, "List should be sorted with duplicates correctly placed");
    }

    @Test
    void testSortIntegersWithNegativeNumbers() throws Exception {
        Method sortIntegersMethod = integerProcessorClass.getDeclaredMethod("sortIntegers", List.class);
        List<Integer> numbers = Arrays.asList(-1, -3, -2, 0, 2, 1);
        List<Integer> result = (List<Integer>) sortIntegersMethod.invoke(processor, numbers);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2), result, "Negative numbers should be correctly sorted with positive numbers");
    }

    @Test
    void testSortIntegersWithSingleElement() throws Exception {
        Method sortIntegersMethod = integerProcessorClass.getDeclaredMethod("sortIntegers", List.class);
        List<Integer> numbers = Collections.singletonList(1);
        List<Integer> result = (List<Integer>) sortIntegersMethod.invoke(processor, numbers);

        assertNotNull(result, "Result should not be null");
        assertEquals(Collections.singletonList(1), result, "Single element list should remain unchanged");
    }

    @Test
    void testSortIntegersWithAllEqualElements() throws Exception {
        Method sortIntegersMethod = integerProcessorClass.getDeclaredMethod("sortIntegers", List.class);
        List<Integer> numbers = Arrays.asList(5, 5, 5, 5, 5);
        List<Integer> result = (List<Integer>) sortIntegersMethod.invoke(processor, numbers);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList(5, 5, 5, 5, 5), result, "List with all equal elements should remain unchanged");
    }

    @Test
    void testSortIntegersWithLargeNumbers() throws Exception {
        Method sortIntegersMethod = integerProcessorClass.getDeclaredMethod("sortIntegers", List.class);
        List<Integer> numbers = Arrays.asList(1000000, 2000000, 1500000);
        List<Integer> result = (List<Integer>) sortIntegersMethod.invoke(processor, numbers);

        assertNotNull(result, "Result should not be null");
        assertEquals(Arrays.asList(1000000, 1500000, 2000000), result, "Large numbers should be sorted correctly");
    }
}
