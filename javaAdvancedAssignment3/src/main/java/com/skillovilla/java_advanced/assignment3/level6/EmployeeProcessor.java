package com.skillovilla.java_advanced.assignment3.level6;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeProcessor {
    public List<Employee> filterBySalary(List<Employee> employees, double threshold) {
        return employees.stream()
                .filter(employee -> employee.getSalary() >= threshold)
                .collect(Collectors.toList());
    }

    public List<String> getEmployeeNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
