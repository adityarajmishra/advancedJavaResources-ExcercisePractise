package com.skillovilla.java_advanced.lab3.level2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class FieldInspectorTest {

    @Test
    void testGetFieldDetails() {
        FieldInspector inspector = new FieldInspector();
        String[] fieldDetails = inspector.getFieldDetails(Device.class);

        // Expected field details output
        String[] expectedDetails = {
                "Field: deviceName Type: String Modifier: private",
                "Field: manufacturer Type: String Modifier: private",
                "Field: price Type: double Modifier: private"
        };

        assertArrayEquals(expectedDetails, fieldDetails, "Field details should match the expected output.");
    }

    @Test
    void testModifyFieldValue() throws Exception {
        FieldInspector inspector = new FieldInspector();
        Device device = new Device();

        // Modify the private field "deviceName"
        inspector.modifyFieldValue(device, "deviceName", "Laptop");

        // Check if the field was modified
        assertEquals("Laptop", device.getDeviceName(), "The device name should be 'Laptop' after modification.");

        // Modify the private field "manufacturer"
        inspector.modifyFieldValue(device, "manufacturer", "Dell");
        assertEquals("Dell", device.getManufacturer(), "The manufacturer should be 'Dell' after modification.");

        // Modify the private field "price"
        inspector.modifyFieldValue(device, "price", 1500.0);
        assertEquals(1500.0, device.getPrice(), 0.001, "The price should be 1500.0 after modification.");
    }

    @Test
    void testPrivateFieldAccess() throws Exception {
        Device device = new Device("Phone", "Apple", 999.99);

        // Access the private field directly using reflection
        Field deviceNameField = Device.class.getDeclaredField("deviceName");
        deviceNameField.setAccessible(true);  // Allow access to private field

        // Get the value of the private field
        String deviceName = (String) deviceNameField.get(device);
        assertEquals("Phone", deviceName, "The device name should be 'Phone'.");

        // Modify the private field using reflection
        deviceNameField.set(device, "Smartphone");
        assertEquals("Smartphone", device.getDeviceName(), "The device name should be updated to 'Smartphone'.");
    }

    @Test
    void testFieldTypeMismatch() {
        FieldInspector inspector = new FieldInspector();
        Device device = new Device();

        // Try to set a field with a wrong data type (e.g., set "deviceName" to a number)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inspector.modifyFieldValue(device, "deviceName", 1234);  // Wrong type
        });

        String expectedMessage = "Can not set java.lang.String field";
        assertTrue(exception.getMessage().contains(expectedMessage), "Expected IllegalArgumentException for type mismatch.");
    }
}
