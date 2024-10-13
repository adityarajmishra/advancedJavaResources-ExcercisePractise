package com.skillovilla.java_advanced.lab7.level3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BankAccountTest {

    @Test
    public void testDepositAndWithdraw() throws Exception {
        // Use reflection to create an instance of BankAccount
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level3.BankAccount");
        Constructor<?> constructor = clazz.getConstructor();
        Object account = constructor.newInstance();

        // Use reflection to deposit 1000 in the account
        Method depositMethod = clazz.getMethod("deposit", double.class);
        depositMethod.invoke(account, 1000.0);

        // Use reflection to get the balance after deposit
        Method getBalanceMethod = clazz.getMethod("getBalance");
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(1000.0, balance, "Balance should be 1000 after depositing 1000.");

        // Use reflection to withdraw 500 from the account
        Method withdrawMethod = clazz.getMethod("withdraw", double.class);
        boolean success = (boolean) withdrawMethod.invoke(account, 500.0);

        // Verify the withdrawal was successful and the balance is updated
        assertTrue(success, "Withdrawal of 500 should succeed.");
        balance = (double) getBalanceMethod.invoke(account);
        assertEquals(500.0, balance, "Balance should be 500 after withdrawing 500.");
    }

    @Test
    public void testOverdraftProtection() throws Exception {
        // Use reflection to create an instance of BankAccount
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level3.BankAccount");
        Constructor<?> constructor = clazz.getConstructor();
        Object account = constructor.newInstance();

        // Use reflection to deposit 500 in the account
        Method depositMethod = clazz.getMethod("deposit", double.class);
        depositMethod.invoke(account, 500.0);

        // Use reflection to attempt to withdraw more than the balance
        Method withdrawMethod = clazz.getMethod("withdraw", double.class);
        boolean success = (boolean) withdrawMethod.invoke(account, 1000.0);

        // Verify the withdrawal fails and the balance remains unchanged
        assertFalse(success, "Withdrawal of 1000 should fail due to insufficient funds.");
        Method getBalanceMethod = clazz.getMethod("getBalance");
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(500.0, balance, "Balance should still be 500 after failed withdrawal.");
    }

    @Test
    public void testConcurrentDepositsAndWithdrawals() throws Exception {
        // Use reflection to create an instance of BankAccount
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level3.BankAccount");
        Constructor<?> constructor = clazz.getConstructor();
        Object account = constructor.newInstance();

        Method depositMethod = clazz.getMethod("deposit", double.class);
        Method withdrawMethod = clazz.getMethod("withdraw", double.class);

        Runnable depositTask = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    depositMethod.invoke(account, 10.0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    withdrawMethod.invoke(account, 5.0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(depositTask);
        Thread t2 = new Thread(depositTask);
        Thread t3 = new Thread(withdrawTask);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Expected final balance
        int expectedBalance = 1000 * 10 * 2 - 1000 * 5;

        // Use reflection to verify the final balance
        Method getBalanceMethod = clazz.getMethod("getBalance");
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(expectedBalance, balance, "Balance should be correctly updated after concurrent deposits and withdrawals.");
    }

    @Test
    public void testConcurrentDepositsOnly() throws Exception {
        // Use reflection to create an instance of BankAccount
        Class<?> clazz = Class.forName("com.skillovilla.java_advanced.lab7.level3.BankAccount");
        Constructor<?> constructor = clazz.getConstructor();
        Object account = constructor.newInstance();

        Method depositMethod = clazz.getMethod("deposit", double.class);

        Runnable depositTask = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    depositMethod.invoke(account, 1.0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(depositTask);
        Thread t2 = new Thread(depositTask);
        Thread t3 = new Thread(depositTask);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        // Expected final balance after concurrent deposits
        int expectedBalance = 1000 * 3;

        // Use reflection to verify the final balance
        Method getBalanceMethod = clazz.getMethod("getBalance");
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(expectedBalance, balance, "Balance should be correctly updated after concurrent deposits.");
    }
}
