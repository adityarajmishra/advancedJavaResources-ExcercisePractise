package com.skillovilla.java_advanced.lab5.level2;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerProcessor {
    public List<Integer> sortIntegers(List<Integer> numbers)
    {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
