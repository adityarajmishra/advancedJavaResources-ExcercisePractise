package com.skillovilla.java_advanced.lab3.level2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldInspector {

    public String[] getFieldDetails(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        String[] fieldDetails = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            String fieldName = field.getName();
            String fieldType = field.getType().getSimpleName();
            String modifiers = Modifier.toString(field.getModifiers());

            String finalField = "Field: " + fieldName + " Type: " + fieldType + " Modifier: " + modifiers;
            fieldDetails[i] = finalField;
        }

        return fieldDetails;
    }


    public void modifyFieldValue(Object obj, String fieldName, Object newValue)
            throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, newValue);
    }
}
