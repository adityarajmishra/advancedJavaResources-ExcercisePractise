package com.skillovilla.java_advanced.level7;

public class DecrementWorker implements Runnable {
    private DecrementCounter counter;

    public DecrementWorker(DecrementCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 500; i++) {
            counter.decrement();
        }
    }

    public void execute(){
        // Create two DecrementWorker instances that share the same counter
        Thread t1 = new Thread(this);
        Thread t2 = new Thread(this);

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }


        // Print the final count
        System.out.println("Final count: "+counter.getCount());
    }}