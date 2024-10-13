package com.skillovilla.java_advanced.lab7.level2;

public class ThreadLifecycleTracker extends Thread {

    public final Object lock = new Object();

    //override the run() method of Thread class and implement the logic to track the lifecycle of the thread
    @Override
    public void run() {
        System.out.println("Thread State: " + this.getState());
        synchronized (lock) {
            System.out.println("Thread is about to wait...");
            try {
                lock.wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread State: " + this.getState());
        synchronized (lock) {
            System.out.println("Thread is about to sleep...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread State: " + this.getState());

        System.out.println("Thread is completing...");
    }
}

