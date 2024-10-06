package com.skillovilla.java_advanced.lab5.level3;

public class Calculator {
    private final MathOperation add = Integer::sum;
    private final MathOperation subtract = (a, b) -> a - b;
    private final MathOperation multiply = (a, b) -> a * b;
    private final MathOperation divide = (a, b) -> a / b;

    public int add(int a, int b) {
        return add.operate(a, b);
    }

    public int subtract(int a, int b) {
        return subtract.operate(a, b);
    }

    public int multiply(int a, int b) {
        return multiply.operate(a, b);
    }

    public int divide(int a, int b) {
        return divide.operate(a, b);
    }
}
