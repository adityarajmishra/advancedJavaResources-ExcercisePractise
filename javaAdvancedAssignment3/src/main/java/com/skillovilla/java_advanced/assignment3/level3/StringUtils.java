package com.skillovilla.java_advanced.assignment3.level3;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public List<String> sortStrings(List<String> strings) {
        //sorted()String::compareToIgnoreCase can be used to sort the strings in case-insensitive order
        return strings.stream().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
    }

    public List<Integer> convertToStringLength(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}
