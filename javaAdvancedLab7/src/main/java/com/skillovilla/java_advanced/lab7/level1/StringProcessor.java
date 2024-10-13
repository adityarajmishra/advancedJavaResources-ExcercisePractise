package com.skillovilla.java_advanced.lab7.level1;

import java.util.*;


public class StringProcessor implements  Runnable{
    private final String input;

    public StringProcessor(String input) {
        this.input = input;
    }

    private int countVowels(String input) {
        return (int) input.chars().filter(c -> "aeiouAEIOU".contains(String.valueOf((char) c))).count();
    }

    // Helper method to count words in the string
    private int countWords(String input) {
        return new StringTokenizer(input).countTokens();
    }


    @Override
    public void run() {
        System.out.println("Reversed String: " + new StringBuilder(input).reverse().toString());
        System.out.println("Number of Vowels: " + countVowels(input));
        System.out.println("Number of Words: " + countWords(input));
    }
}
