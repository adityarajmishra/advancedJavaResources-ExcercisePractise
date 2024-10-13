package com.skillovilla.java_advanced.level1;

public class ReverseString implements Runnable{
    // Reverse the string "Hello, World!"
    public void run(){
        String name = "Hello, World!";
        System.out.println(new StringBuilder(name).reverse().toString());
    }


}
