package com.skillovilla.java_advanced.level3;

import java.util.concurrent.atomic.AtomicInteger;

public class AsynchronousTasks {
    public void executeTasks() throws InterruptedException {
        Thread thread1 = new Thread(task1());
        Thread thread2 = new Thread(task2());

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to complete
        thread1.join();
        thread2.join();
    }
    public Runnable task1() {
        return () -> {
            int sum = 0;
            for (int i = 1; i <= 1000; i++) {
                sum += i;
            }
            System.out.println("Sum of first 1000 natural numbers: " + sum);
        };
    }

    public Runnable task2() {
        return () -> {
            long sumOfSquares = 0;
            for (int i = 1; i <= 1000; i++) {
                sumOfSquares += i * i;
            }
            System.out.println("Sum of squares of first 1000 natural numbers: " + sumOfSquares);
        };
    }
}

