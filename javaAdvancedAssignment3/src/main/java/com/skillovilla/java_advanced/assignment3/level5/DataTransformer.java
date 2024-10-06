package com.skillovilla.java_advanced.assignment3.level5;

import java.util.List;
import java.util.stream.Collectors;

public class DataTransformer {

    public List<String> filterAndTransform(List<String> data) {
        return data.stream().filter(s -> !s.contains("e")).map(String::toUpperCase).collect(Collectors.toList());
    }

    public List<Integer> squareEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
    }
}
