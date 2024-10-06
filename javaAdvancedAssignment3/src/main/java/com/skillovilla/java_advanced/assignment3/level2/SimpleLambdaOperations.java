package com.skillovilla.java_advanced.assignment3.level2;

public class SimpleLambdaOperations {
        private final Operation addOperation = Integer::sum;
        private final Operation subtractOperation = (a, b) -> a - b;
        private final Operation multiplyOperation = (a, b) -> a * b;
        private final Operation divideOperation = (a, b) -> a / b;

        public int add(int a, int b) {
            return addOperation.operate(a, b);
        }

        public int subtract(int a, int b) {
            return subtractOperation.operate(a, b);
        }

        public int multiply(int a, int b) {
            return multiplyOperation.operate(a, b);
        }

        public int divide(int a, int b) {
            if (b == 0) {
                return 0;
            }
            return divideOperation.operate(a, b);
        }
}
