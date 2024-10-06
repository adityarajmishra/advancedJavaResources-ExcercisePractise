package com.skillovilla.java_advanced.assignment3.level9;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeProcessor {
    public Map<Boolean, List<Employee>> partitionEmployeesBySalary(List<Employee> employees, double threshold) {
        return employees.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() >= threshold));
    }
}
