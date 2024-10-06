package com.skillovilla.java_advanced.assignment3.level9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level10Test {

    private Class<?> employeeProcessorClass;
    private Object employeeProcessorInstance;

    @BeforeEach
    void setUp() throws Exception {
        employeeProcessorClass = Class.forName("com.skillovilla.java_advanced.assignment3.level9.EmployeeProcessor");
        employeeProcessorInstance = employeeProcessorClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testPartitionEmployeesBySalary() throws Exception {
        Method partitionEmployeesBySalaryMethod = employeeProcessorClass.getMethod("partitionEmployeesBySalary", List.class, double.class);
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 60000),
            new Employee("Charlie", 40000),
            new Employee("David", 70000)
        );

        Map<Boolean, List<Employee>> result = (Map<Boolean, List<Employee>>) partitionEmployeesBySalaryMethod.invoke(employeeProcessorInstance, employees, 50000);

        // Assert employees with salary >= 50000
        assertEquals(3, result.get(true).size(), "There should be 3 employees with salary >= 50000");
        assertEquals("Alice", result.get(true).get(0).getName(), "First employee with salary >= 50000 should be Alice");
        assertEquals("Bob", result.get(true).get(1).getName(), "Second employee with salary >= 50000 should be Bob");
        assertEquals("David", result.get(true).get(2).getName(), "Third employee with salary >= 50000 should be David");

        // Assert employees with salary < 50000
        assertEquals(1, result.get(false).size(), "There should be 1 employee with salary < 50000");
        assertEquals("Charlie", result.get(false).get(0).getName(), "The employee with salary < 50000 should be Charlie");
    }
}
