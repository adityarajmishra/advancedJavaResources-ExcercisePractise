package com.skillovilla.java_advanced.assignment3.level8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {
//    public List<String> getEmployeeNamesBySalary(List<Employee> employees, double threshold){
//        List<String> employeeNames = new ArrayList<>();
//        for(Employee employee : employees){
//            if(employee.getSalary() > threshold){
//                employeeNames.add(employee.getName());
//            }
//        }
//        return employeeNames;
//    }
//
//    public double calculateTotalSalary(List<Employee> employees){
//        double totalSalary = 0;
//        for(Employee employee : employees){
//            totalSalary += employee.getSalary();
//        }
//        return totalSalary;
//    }
public List<String> getEmployeeNamesBySalary(List<Employee> employees, double threshold) {
    return employees.stream()
            .filter(employee -> employee.getSalary() > threshold)
            .map(Employee::getName)
            .sorted()
            .collect(Collectors.toList());
}

    public double calculateTotalSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

}
