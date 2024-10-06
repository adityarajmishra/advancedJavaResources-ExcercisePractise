package com.skillovilla.java_advanced.assignment3.level7;

import java.util.List;
import java.util.stream.Collectors;

public class StudentFilter {
    public List<Student> filterByGrade(List<Student> students, double threshold){
        return students.stream().filter(student -> student.getGrade() > threshold).collect(Collectors.toList());
    }
    public List<String> getHonorStudents(List<Student> students, double threshold){
        return students.stream().filter(student -> student.getGrade() > threshold).map(Student::getName).collect(Collectors.toList());
    }
}
