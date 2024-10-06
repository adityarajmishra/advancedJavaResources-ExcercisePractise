package com.skillovilla.java_advanced.lab5.level4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionProcessorTest {

    private Class<?> transactionProcessorClass;
    private Object processor;

    @BeforeEach
    void setUp() throws Exception {
        transactionProcessorClass = Class.forName("com.skillovilla.java_advanced.lab5.level4.TransactionProcessor");
        processor = transactionProcessorClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testCalculateTotalAmount() throws Exception {
        Method calculateTotalAmountMethod = transactionProcessorClass.getDeclaredMethod("calculateTotalAmount", List.class);
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", 100.0, TransactionCategory.FOOD, TransactionStatus.COMPLETED),
                new Transaction("T2", 200.0, TransactionCategory.ELECTRONICS, TransactionStatus.PENDING),
                new Transaction("T3", 150.0, TransactionCategory.CLOTHING, TransactionStatus.COMPLETED)
        );
        double totalAmount = (double) calculateTotalAmountMethod.invoke(processor, transactions);

        assertNotNull(calculateTotalAmountMethod, "Method calculateTotalAmount should exist");
        assertEquals(250.0, totalAmount, 0.01, "Total amount of completed transactions should be 250.0");
    }

}
