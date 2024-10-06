package com.skillovilla.java_advanced.lab4.level3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTransactionReflectionTest {

    private final String tmpDir = System.getProperty("java.io.tmpdir");
    private final String filePath = tmpDir + "/test_payment_transaction.ser";

    @BeforeEach
    void setUp() {
        // Ensure the file doesn't exist before the test
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @AfterEach
    void tearDown() {
        // Clean up: delete the file after test execution
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    // Test creating a PaymentTransaction object using reflection
    @Test
    void testCreateObjectWithReflection() throws Exception {
        // Load the PaymentTransaction class using reflection
        Class<?> transactionClass = Class.forName("com.skillovilla.java_advanced.lab4.level3.PaymentTransaction");

        // Get the constructor for PaymentTransaction
        Constructor<?> constructor = transactionClass.getConstructor(String.class, double.class, String.class, String.class);

        // Create an instance of PaymentTransaction using reflection
        Object transactionInstance = constructor.newInstance("TXN12345", 250.75, "1234-5678-9012", "2024-08-29");

        // Access and invoke the getter methods using reflection
        Method getTransactionId = transactionClass.getMethod("getTransactionId");
        Method getAmount = transactionClass.getMethod("getAmount");
        Method getCardNumber = transactionClass.getMethod("getCardNumber");
        Method getTransactionDate = transactionClass.getMethod("getTransactionDate");

        // Assert the values using reflection
        assertEquals("TXN12345", getTransactionId.invoke(transactionInstance), "Transaction ID should match");
        assertEquals(250.75, getAmount.invoke(transactionInstance), "Amount should match");
        assertEquals("1234-5678-9012", getCardNumber.invoke(transactionInstance), "Card number should match");
        assertEquals("2024-08-29", getTransactionDate.invoke(transactionInstance), "Transaction date should match");
    }

    // Test serialization of PaymentTransaction object using reflection
    @Test
    void testSerializationWithReflection() throws Exception {
        // Load the PaymentTransaction class using reflection
        Class<?> transactionClass = Class.forName("com.skillovilla.java_advanced.lab4.level3.PaymentTransaction");

        // Get the constructor and create an instance of PaymentTransaction
        Constructor<?> constructor = transactionClass.getConstructor(String.class, double.class, String.class, String.class);
        Object transactionInstance = constructor.newInstance("TXN12345", 250.75, "1234-5678-9012", "2024-08-29");

        // Load the PaymentTransactionSerializer class using reflection
        Class<?> serializerClass = Class.forName("com.skillovilla.java_advanced.lab4.level3.PaymentTransactionSerializer");

        // Get the serializeTransaction method and invoke it
        Method serializeMethod = serializerClass.getMethod("serializeTransaction", transactionClass, String.class);
        serializeMethod.invoke(serializerClass.getDeclaredConstructor().newInstance(), transactionInstance, filePath);

        // Verify that the file was created
        File file = new File(filePath);
        assertTrue(file.exists(), "Serialized file should exist");
    }

    // Test deserialization of PaymentTransaction object using reflection
    @Test
    void testDeserializationWithReflection() throws Exception {
        // Step 1: Create and serialize a PaymentTransaction object using reflection
        Class<?> transactionClass = Class.forName("com.skillovilla.java_advanced.lab4.level3.PaymentTransaction");
        Constructor<?> constructor = transactionClass.getConstructor(String.class, double.class, String.class, String.class);
        Object transactionInstance = constructor.newInstance("TXN12345", 250.75, "1234-5678-9012", "2024-08-29");

        Class<?> serializerClass = Class.forName("com.skillovilla.java_advanced.lab4.level3.PaymentTransactionSerializer");
        Method serializeMethod = serializerClass.getMethod("serializeTransaction", transactionClass, String.class);
        serializeMethod.invoke(serializerClass.getDeclaredConstructor().newInstance(), transactionInstance, filePath);

        // Step 2: Deserialize the object using reflection
        Class<?> deserializerClass = Class.forName("com.skillovilla.java_advanced.lab4.level3.PaymentTransactionDeserializer");
        Method deserializeMethod = deserializerClass.getMethod("deserializeTransaction", String.class);
        Object deserializedTransaction = deserializeMethod.invoke(deserializerClass.getDeclaredConstructor().newInstance(), filePath);

        // Step 3: Access and invoke the getter methods using reflection to verify the deserialized object
        Method getTransactionId = transactionClass.getMethod("getTransactionId");
        Method getAmount = transactionClass.getMethod("getAmount");
        Method getCardNumber = transactionClass.getMethod("getCardNumber");
        Method getTransactionDate = transactionClass.getMethod("getTransactionDate");

        // Verify that the fields were correctly deserialized (except the transient cardNumber field)
        assertEquals("TXN12345", getTransactionId.invoke(deserializedTransaction), "Transaction ID should match");
        assertEquals(250.75, getAmount.invoke(deserializedTransaction), "Amount should match");
        assertNull(getCardNumber.invoke(deserializedTransaction), "Card number should be null due to transient keyword");
        assertEquals("2024-08-29", getTransactionDate.invoke(deserializedTransaction), "Transaction date should match");
    }

    @Test
    void testModifyFieldsUsingReflection() throws Exception {
        // Step 1: Use reflection to load the PaymentTransaction class
        Class<?> transactionClass = Class.forName("com.skillovilla.java_advanced.lab4.level3.PaymentTransaction");

        // Step 2: Get the default constructor and create a new instance
        Constructor<?> constructor = transactionClass.getConstructor(String.class, double.class, String.class, String.class);
        Object transactionInstance = constructor.newInstance("TXN67890", 450.30, "9876-5432-1098", "2024-09-01");

        // Step 3: Modify fields using reflection
        // Modify transactionId
        Field transactionIdField = transactionClass.getDeclaredField("transactionId");
        transactionIdField.setAccessible(true); // Make it accessible if it's private
        transactionIdField.set(transactionInstance, "TXN99999");

        // Modify amount
        Field amountField = transactionClass.getDeclaredField("amount");
        amountField.setAccessible(true); // Make it accessible if it's private
        amountField.set(transactionInstance, 550.60);

        // Modify cardNumber (transient field)
        Field cardNumberField = transactionClass.getDeclaredField("cardNumber");
        cardNumberField.setAccessible(true); // Make it accessible if it's private
        cardNumberField.set(transactionInstance, "4321-9876-5432");

        // Modify transactionDate
        Field transactionDateField = transactionClass.getDeclaredField("transactionDate");
        transactionDateField.setAccessible(true); // Make it accessible if it's private
        transactionDateField.set(transactionInstance, "2024-09-10");

        // Step 4: Use reflection to call the getter methods and verify the changes
        Method getTransactionId = transactionClass.getMethod("getTransactionId");
        Method getAmount = transactionClass.getMethod("getAmount");
        Method getCardNumber = transactionClass.getMethod("getCardNumber");
        Method getTransactionDate = transactionClass.getMethod("getTransactionDate");

        assertEquals("TXN99999", getTransactionId.invoke(transactionInstance), "Transaction ID should be 'TXN99999'");
        assertEquals(550.60, getAmount.invoke(transactionInstance), "Amount should be 550.60");
        assertEquals("4321-9876-5432", getCardNumber.invoke(transactionInstance), "Card number should be '4321-9876-5432'");
        assertEquals("2024-09-10", getTransactionDate.invoke(transactionInstance), "Transaction date should be '2024-09-10'");
    }

}
