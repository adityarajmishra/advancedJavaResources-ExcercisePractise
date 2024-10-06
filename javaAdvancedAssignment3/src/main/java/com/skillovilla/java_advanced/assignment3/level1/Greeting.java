package com.skillovilla.java_advanced.assignment3.level1;

public interface Greeting {
    default void sayHello(){
        System.out.println("Hello");
    }
}
