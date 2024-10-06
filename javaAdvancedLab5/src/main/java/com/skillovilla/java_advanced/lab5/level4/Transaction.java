package com.skillovilla.java_advanced.lab5.level4;

public class Transaction {
    private final String id;
    private final double amount;
    private final TransactionCategory category;
    private final TransactionStatus status;

    public Transaction(String id, double amount, TransactionCategory category, TransactionStatus status) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionCategory getCategory() {
        return category;
    }

    public TransactionStatus getStatus() {
        return status;
    }
}
