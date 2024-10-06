package com.skillovilla.java_advanced.lab5.level4;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionProcessor {

    public double calculateTotalAmount(List<Transaction> transactions) {
        return transactions.parallelStream().filter(transaction -> transaction.getStatus() == TransactionStatus.COMPLETED).mapToDouble(Transaction::getAmount).sum();
    }
}
