package com.skillovilla.java_advanced.level6;

public class CounterThread {

    public void execute() throws InterruptedException {
        // Step 1: Create a Runnable that counts from 1 to 5
        Runnable runnable = ()->{
            for(int i=1;i<=5;i++){
                System.out.println("Count: "+i);
            }
        };
        // Step 2: Create a Thread with this Runnable and start it
        Thread thread = new Thread(runnable);
        thread.start();
        // Step 3: Wait for the thread to finish counting
        try{
            thread.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        // Print a message after counting is complete
        System.out.println("Counting complete");
    }
}
