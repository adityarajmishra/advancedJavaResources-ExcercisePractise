package com.skillovilla.java_advanced.assignment3.level1;

public class GreetingService {

    public void greet() {
        // Create an anonymous inner class that implements the Greeting interface
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello World!");
            }
        };


        // Call the sayHello method
        greeting.sayHello();
    }
}
