package com.skillovilla.java_advanced.lab5.level1;

import java.util.List;
import java.util.stream.Collectors;

public class StringProcessor {
    public List<String> processStrings(List<String> strings)
    {
        return strings.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
