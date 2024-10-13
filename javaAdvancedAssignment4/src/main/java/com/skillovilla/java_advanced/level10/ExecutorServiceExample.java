package com.skillovilla.java_advanced.level10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    public void executeTasks() {
        // Step 1: Create a fixed thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Step 2: Create and submit 5 tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;  // Final variable to use in lambda expression
            executorService.submit(() -> {
                // Simulate task execution
                System.out.println("Task-" + taskId + " is being executed by " + Thread.currentThread().getName());
                // You can add some processing here if needed
                try {
                    Thread.sleep(500); // Simulate some work with sleep
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Step 3: Shutdown the executor service
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}