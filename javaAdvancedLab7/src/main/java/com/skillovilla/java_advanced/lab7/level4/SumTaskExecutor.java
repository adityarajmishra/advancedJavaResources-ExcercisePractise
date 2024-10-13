package com.skillovilla.java_advanced.lab7.level4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumTaskExecutor {

    public Integer executeSumTask(int number) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new SumTask(number));
        try {
            return future.get();
        } catch (Exception e) {
            throw e;
        } finally {
            executorService.shutdown();
        }
    }
}
