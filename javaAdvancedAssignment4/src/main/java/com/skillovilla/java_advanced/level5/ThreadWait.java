package com.skillovilla.java_advanced.level5;

public class ThreadWait{

    public void execute() {
        // Step 1: Create a Runnable that prints a message "Runnable is waiting"
        Runnable runnable = ()->{
            System.out.println("Runnable is waiting");
        };
        // Step 2: Create a Thread with this Runnable and start it
        Thread thread = new Thread(runnable);
        thread.start();
        // Step 3: Wait for the thread to finish execution
        try {
            thread.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        // Print a message after the wait "Thread has completed execution"
        System.out.println("Thread has completed execution");
    }
}
