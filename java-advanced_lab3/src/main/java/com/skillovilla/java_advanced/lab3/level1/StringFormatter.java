package com.skillovilla.java_advanced.lab3.level1;

public class StringFormatter implements Formatter<String> {
    @Override
    public String format(String s) {
        return "Formatter String: "+s.toUpperCase();
    }
}
