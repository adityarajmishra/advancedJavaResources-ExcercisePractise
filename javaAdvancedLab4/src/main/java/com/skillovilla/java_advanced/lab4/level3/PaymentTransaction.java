package com.skillovilla.java_advanced.lab4.level3;

import java.io.Serializable;

public class PaymentTransaction implements Serializable {
    String transactionId;
    double amount;
    transient String cardNumber;//don't want to serializable.
    String transactionDate;

    public PaymentTransaction() {
    }

    public PaymentTransaction(String transactionId, double amount, String cardNumber, String transactionDate) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
