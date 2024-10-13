package com.skillovilla.java_advanced.lab7.level4;


import java.util.concurrent.Callable;

public class SumTask implements  Callable<Integer> {
    private final int number;

    public SumTask(int number) {
        this.number = number;
    }


    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }
}
