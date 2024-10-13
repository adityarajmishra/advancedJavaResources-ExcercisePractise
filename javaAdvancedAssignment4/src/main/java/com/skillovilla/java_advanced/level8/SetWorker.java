package com.skillovilla.java_advanced.level8;

class SetWorker implements Runnable {
    private final SharedSet sharedSet;

    public SetWorker(SharedSet sharedSet) {
        this.sharedSet = sharedSet;
    }

    @Override
    public void run() {
        // Each worker will add integers from 1 to 100 to the shared set
        for (int i = 1; i <= 100; i++) {
            sharedSet.addElement(i);
        }
    }

    public void execute() {
        // Create two threads that share the same SharedSet instance
        Thread t1 = new Thread(this);
        Thread t2 = new Thread(this);

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Print the final set contents and size
        System.out.println("Final set contents: " + sharedSet.getElements());
        System.out.println("Set size: " + sharedSet.getElements().size());
    }
}
