package com.skillovilla.java_advanced.assignment3.level4;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

    public List<String> filterAndSortStrings(List<String> strings) {
        return strings.stream().filter(s -> s.length() > 3).sorted().collect(Collectors.toList());
    }

    public int sumOfLengths(List<String> strings) {
        return strings.stream().mapToInt(String::length).sum();
    }
}
