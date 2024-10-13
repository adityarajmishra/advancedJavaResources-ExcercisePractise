package com.skillovilla.java_advanced.level4;

public class FactorialCalculator implements Runnable{
    private final int number;

    public FactorialCalculator(int num){
        this.number = num;
    }

    public void run(){
        long fact =1L;
        for(int i=1;i<=number;i++){
            fact = fact*i;
        }
        System.out.println("Factorial of "+number+" is "+fact);
    }

}
