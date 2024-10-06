package com.skillovilla.java_advanced.lab4.level1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GadgetReflectionTest {

    @TempDir
    Path tempDir; // JUnit's TempDir to hold the temporary folder

    File tempFile;

    @AfterEach
    void cleanup() {
        // Ensure that the temporary file is deleted after each test
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }

    // Test for serializing a Gadget object using reflection and storing it in the temp folder
    @Test
    void testSerializeGadgetWithReflection() throws Exception {
        // Dynamically load the Gadget class using reflection
        Class<?> gadgetClass = Class.forName("com.skillovilla.java_advanced.lab4.level1.Gadget");

        // Create a Gadget object using reflection
        Object gadget = createGadgetUsingReflection(gadgetClass, "iPhone 12", "Apple", 999.99);

        // Create the temporary file inside the temp directory
        tempFile = new File(tempDir.toFile(), "gadget.ser");

        // Dynamically load the GadgetSerializer class using reflection
        Class<?> serializerClass = Class.forName("com.skillovilla.java_advanced.lab4.level1.GadgetSerializer");

        // Create an instance of the GadgetSerializer class
        Object serializerInstance = serializerClass.getDeclaredConstructor().newInstance();

        // Use reflection to invoke the serializeGadget method
        Method serializeMethod = serializerClass.getMethod("serializeGadget", gadgetClass, String.class);
        serializeMethod.invoke(serializerInstance, gadget, tempFile.getAbsolutePath()); // Serialize the Gadget object

        // Check if the file exists after serialization
        assertTrue(tempFile.exists(), "Serialized file should exist after serialization");
    }

    // Test for deserializing a Gadget object and verifying its fields using reflection
    @Test
    void testDeserializeAndCheckFieldsAndMethods() throws Exception {
        // Dynamically load the Gadget class using reflection
        Class<?> gadgetClass = Class.forName("com.skillovilla.java_advanced.lab4.level1.Gadget");

        // Create a Gadget object using reflection and serialize it
        Object gadget = createGadgetUsingReflection(gadgetClass, "iPhone 12", "Apple", 999.99);

        // Create the temporary file inside the temp directory
        tempFile = new File(tempDir.toFile(), "gadget.ser");

        // Dynamically load the GadgetSerializer class using reflection
        Class<?> serializerClass = Class.forName("com.skillovilla.java_advanced.lab4.level1.GadgetSerializer");

        // Create an instance of the GadgetSerializer class
        Object serializerInstance = serializerClass.getDeclaredConstructor().newInstance();

        // Use reflection to invoke the serializeGadget method
        Method serializeMethod = serializerClass.getMethod("serializeGadget", gadgetClass, String.class);
        serializeMethod.invoke(serializerInstance, gadget, tempFile.getAbsolutePath()); // Serialize the Gadget object

        // Deserialize the Gadget object directly within the test using reflection
        Object deserializedGadget = deserializeGadgetUsingReflection(tempFile.getAbsolutePath(), gadgetClass);

        // Verify the private fields using reflection
        checkPrivateFieldsUsingReflection(deserializedGadget);

        // Invoke the getter methods using reflection
        invokeGetterMethodsUsingReflection(deserializedGadget);
    }

    // Helper method to create a Gadget object using reflection
    private Object createGadgetUsingReflection(Class<?> gadgetClass, String model, String brand, double price) throws Exception {
        // Get the constructor for the Gadget class
        Constructor<?> constructor = gadgetClass.getDeclaredConstructor(String.class, String.class, double.class);

        // Use the constructor to create a Gadget object
        return constructor.newInstance(model, brand, price);
    }

    // Helper method to check private fields using reflection
    private void checkPrivateFieldsUsingReflection(Object deserializedGadget) throws Exception {
        Class<?> clazz = deserializedGadget.getClass();

        // Access the private field 'model' and verify its value
        Field modelField = clazz.getDeclaredField("model");
        modelField.setAccessible(true);
        String modelValue = (String) modelField.get(deserializedGadget);
        assertEquals("iPhone 12", modelValue, "Expected model to be 'iPhone 12'");

        // Access the private field 'brand' and verify its value
        Field brandField = clazz.getDeclaredField("brand");
        brandField.setAccessible(true);
        String brandValue = (String) brandField.get(deserializedGadget);
        assertEquals("Apple", brandValue, "Expected brand to be 'Apple'");

        // Access the private field 'price' and verify its value
        Field priceField = clazz.getDeclaredField("price");
        priceField.setAccessible(true);
        double priceValue = priceField.getDouble(deserializedGadget);
        assertEquals(999.99, priceValue, 0.01, "Expected price to be 999.99");
    }

    // Helper method to invoke getter methods using reflection
    private void invokeGetterMethodsUsingReflection(Object gadget) throws Exception {
        Class<?> clazz = gadget.getClass();

        // Invoke getModel() method
        Method getModelMethod = clazz.getDeclaredMethod("getModel");
        String modelValue = (String) getModelMethod.invoke(gadget);
        assertEquals("iPhone 12", modelValue, "Expected getModel() to return 'iPhone 12'");

        // Invoke getBrand() method
        Method getBrandMethod = clazz.getDeclaredMethod("getBrand");
        String brandValue = (String) getBrandMethod.invoke(gadget);
        assertEquals("Apple", brandValue, "Expected getBrand() to return 'Apple'");

        // Invoke getPrice() method
        Method getPriceMethod = clazz.getDeclaredMethod("getPrice");
        double priceValue = (double) getPriceMethod.invoke(gadget);
        assertEquals(999.99, priceValue, 0.01, "Expected getPrice() to return 999.99");
    }

    // Helper method to deserialize a Gadget object from a file directly in the test
    private Object deserializeGadgetUsingReflection(String filename, Class<?> gadgetClass) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return in.readObject(); // Deserialize the Gadget object
        }
    }
}
