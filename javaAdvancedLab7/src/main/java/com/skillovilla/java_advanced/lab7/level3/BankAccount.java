package com.skillovilla.java_advanced.lab7.level3;


public class BankAccount {
    private double balance = 0.0;

    public void deposit(double amount) {
        if (amount > 0) {
            synchronized (this) {
                balance += amount;
            }
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            synchronized (this) {
                if (balance >= amount) {
                    balance -= amount;
                    return true;
                }
            }
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}
