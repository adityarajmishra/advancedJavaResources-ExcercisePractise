package com.skillovilla.java_advanced.level9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class FactorialTask implements Callable<Long> {
    private final int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    @Override
    public Long call() {
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        System.out.println("Factorial of " + number + " is " + result);
        return result;
    }

    public static List<Long> executeTasks() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Long>> futures = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            FactorialTask task = new FactorialTask(i * 3);
            Future<Long> future = executorService.submit(task);
            futures.add(future);
        }

        List<Long> results = new ArrayList<>();
        for (Future<Long> future : futures) {
            results.add(future.get());
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        return results;
    }
}