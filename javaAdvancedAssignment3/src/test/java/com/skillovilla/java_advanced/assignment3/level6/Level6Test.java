package com.skillovilla.java_advanced.assignment3.level6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level6Test {

    private Class<?> employeeProcessorClass;
    private Object employeeProcessorInstance;

    @BeforeEach
    void setUp() throws Exception {
        employeeProcessorClass = Class.forName("com.skillovilla.java_advanced.assignment3.level6.EmployeeProcessor");
        employeeProcessorInstance = employeeProcessorClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testFilterBySalary() throws Exception {
        Method filterBySalaryMethod = employeeProcessorClass.getMethod("filterBySalary", List.class, double.class);
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 60000),
            new Employee("Charlie", 40000)
        );
        List<Employee> result = (List<Employee>) filterBySalaryMethod.invoke(employeeProcessorInstance, employees, 50000);
        
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Bob", result.get(1).getName());
    }

    @Test
    void testGetEmployeeNames() throws Exception {
        Method getEmployeeNamesMethod = employeeProcessorClass.getMethod("getEmployeeNames", List.class);
        List<Employee> employees = Arrays.asList(
            new Employee("Charlie", 40000),
            new Employee("Alice", 50000),
            new Employee("Bob", 60000)
        );
        List<String> result = (List<String>) getEmployeeNamesMethod.invoke(employeeProcessorInstance, employees);
        
        assertEquals(Arrays.asList("Alice", "Bob", "Charlie"), result);
    }
}
