package com.skillovilla.java_advanced.level2;

public class ReverseString {
    // Reverse the string "Hello, World!"
    public Runnable getRunnable(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String name = "Hello, World!";
                System.out.println(new StringBuilder(name).reverse().toString());
            }
        };
        return runnable;
    }


}
