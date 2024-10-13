package com.skillovilla.java_advanced.level7;

public class DecrementCounter {
    private int count;

    public DecrementCounter() {
        this.count = 1000;
    }

    public synchronized void decrement() {
        count = count -1;
    }

    public synchronized int getCount() {
        return count;
    }

}
