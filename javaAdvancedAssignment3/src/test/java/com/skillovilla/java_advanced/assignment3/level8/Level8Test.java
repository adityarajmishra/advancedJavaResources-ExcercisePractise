package com.skillovilla.java_advanced.assignment3.level8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level8Test {

    private Class<?> employeeManagerClass;
    private Object employeeManagerInstance;

    @BeforeEach
    void setUp() throws Exception {
        employeeManagerClass = Class.forName("com.skillovilla.java_advanced.assignment3.level8.EmployeeManager");
        employeeManagerInstance = employeeManagerClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testGetEmployeeNamesBySalary() throws Exception {
        Method getEmployeeNamesBySalaryMethod = employeeManagerClass.getMethod("getEmployeeNamesBySalary", List.class, double.class);
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 60000),
            new Employee("Charlie", 70000)
        );
        List<String> result = (List<String>) getEmployeeNamesBySalaryMethod.invoke(employeeManagerInstance, employees, 55000);
        
        assertEquals(Arrays.asList("Bob", "Charlie"), result);
    }

    @Test
    void testCalculateTotalSalary() throws Exception {
        Method calculateTotalSalaryMethod = employeeManagerClass.getMethod("calculateTotalSalary", List.class);
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 60000),
            new Employee("Charlie", 70000)
        );
        double result = (double) calculateTotalSalaryMethod.invoke(employeeManagerInstance, employees);
        
        assertEquals(180000, result);
    }
}
