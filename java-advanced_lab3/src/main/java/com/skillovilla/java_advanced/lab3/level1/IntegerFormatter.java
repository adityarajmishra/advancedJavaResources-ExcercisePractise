package com.skillovilla.java_advanced.lab3.level1;

public class IntegerFormatter implements Formatter<Integer> {
    @Override
    public String format(Integer integer) {
        if(integer%2==0){
            return "Formatted Integer: "+ integer +" - "+ "This is an even number";

        }
        else{
            return "Formatted Integer: "+ integer +" - "+ "This is an odd number";
        }
    }
}
