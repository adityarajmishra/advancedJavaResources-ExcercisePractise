package com.skillovilla.java_advanced.lab4.level2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class DeviceSerializationReflectionTest {

    private static final String TMP_DIR = System.getProperty("java.io.tmpdir") + "/device_data_test/";
    private static final String FILE_PATH = TMP_DIR + "device_data.ser";

    @BeforeEach
    void setUp() throws Exception {
        // Create the temp directory
        File tmpDir = new File(TMP_DIR);
        if (!tmpDir.exists()) {
            tmpDir.mkdirs();
        }
    }

    @AfterEach
    void tearDown() throws Exception {
        // Clean up the temp directory after the test
        Files.deleteIfExists(new File(FILE_PATH).toPath());
        Files.deleteIfExists(new File(TMP_DIR).toPath());
    }

    // Test for serializing and deserializing a Device object using reflection
    @Test
    void testSerializationAndDeserializationWithReflection() throws Exception {
        // Step 1: Dynamically load the Device class using reflection
        Class<?> deviceClass = Class.forName("com.skillovilla.java_advanced.lab4.level2.Device");

        // Get the parameterized constructor and instantiate the Device object
        Constructor<?> constructor = deviceClass.getConstructor(String.class, String.class, double.class);
        Object device = constructor.newInstance("Smartphone", "BrandX", 999.99);

        // Step 2: Serialize the device object using reflection
        serializeDeviceUsingReflection(device);

        // Step 3: Deserialize the object and compare values
        Object deserializedDevice = deserializeDeviceUsingReflection();

        // Step 4: Invoke the getter methods using reflection and verify the values
        Method getModelNameMethod = deviceClass.getMethod("getModelName");
        Method getManufacturerMethod = deviceClass.getMethod("getManufacturer");
        Method getCostMethod = deviceClass.getMethod("getCost");

        assertEquals(getModelNameMethod.invoke(device), getModelNameMethod.invoke(deserializedDevice));
        assertEquals(getManufacturerMethod.invoke(device), getManufacturerMethod.invoke(deserializedDevice));
        assertEquals((double) getCostMethod.invoke(device), (double) getCostMethod.invoke(deserializedDevice), 0.001);
    }

    // Serialize the device object using reflection
    private void serializeDeviceUsingReflection(Object device) throws Exception {
        // Dynamically load the DeviceDataSaver class using reflection
        Class<?> deviceSaverClass = Class.forName("com.skillovilla.java_advanced.lab4.level2.DeviceDataSaver");

        // Get the serialize method
        Method serializeMethod = deviceSaverClass.getMethod("saveDeviceData", device.getClass(), String.class);

        // Invoke the method using reflection
        serializeMethod.invoke(deviceSaverClass.getDeclaredConstructor().newInstance(), device, FILE_PATH);
    }

    // Deserialize the device object using reflection
    private Object deserializeDeviceUsingReflection() throws Exception {
        // Dynamically load the DeviceDataLoader class using reflection
        Class<?> deviceLoaderClass = Class.forName("com.skillovilla.java_advanced.lab4.level2.DeviceDataLoader");

        // Get the deserialize method
        Method deserializeMethod = deviceLoaderClass.getMethod("loadDeviceData", String.class);

        // Invoke the method using reflection and return the deserialized object
        return deserializeMethod.invoke(deviceLoaderClass.getDeclaredConstructor().newInstance(), FILE_PATH);
    }

    // Test for checking constructor and methods using reflection
    @Test
    void testConstructorAndMethodsUsingReflection() throws Exception {
        // Dynamically load the Device class using reflection
        Class<?> deviceClass = Class.forName("com.skillovilla.java_advanced.lab4.level2.Device");

        // Get the parameterized constructor and instantiate the Device object
        Constructor<?> constructor = deviceClass.getConstructor(String.class, String.class, double.class);
        Object device = constructor.newInstance("Laptop", "BrandY", 1500.00);

        // Get and invoke methods using reflection
        Method getModelNameMethod = deviceClass.getMethod("getModelName");
        Method getManufacturerMethod = deviceClass.getMethod("getManufacturer");
        Method getCostMethod = deviceClass.getMethod("getCost");

        // Assert the values using reflection
        assertEquals("Laptop", getModelNameMethod.invoke(device));
        assertEquals("BrandY", getManufacturerMethod.invoke(device));
        assertEquals(1500.00, (double) getCostMethod.invoke(device), 0.001);
    }

    // Test for dynamically modifying fields using reflection
    @Test
    void testModifyFieldsUsingReflection() throws Exception {
        // Dynamically load the Device class using reflection
        Class<?> deviceClass = Class.forName("com.skillovilla.java_advanced.lab4.level2.Device");

        // Get the default constructor and instantiate the Device object
        Constructor<?> defaultConstructor = deviceClass.getConstructor();
        Object device = defaultConstructor.newInstance();

        // Dynamically access and modify fields using reflection
        Field modelNameField = deviceClass.getDeclaredField("modelName");
        Field manufacturerField = deviceClass.getDeclaredField("manufacturer");
        Field costField = deviceClass.getDeclaredField("cost");

        // Make private fields accessible
        modelNameField.setAccessible(true);
        manufacturerField.setAccessible(true);
        costField.setAccessible(true);

        // Set the field values using reflection
        modelNameField.set(device, "Tablet");
        manufacturerField.set(device, "BrandZ");
        costField.set(device, 300.00);

        // Verify the field values using reflection
        assertEquals("Tablet", modelNameField.get(device));
        assertEquals("BrandZ", manufacturerField.get(device));
        assertEquals(300.00, costField.get(device));
    }
}
