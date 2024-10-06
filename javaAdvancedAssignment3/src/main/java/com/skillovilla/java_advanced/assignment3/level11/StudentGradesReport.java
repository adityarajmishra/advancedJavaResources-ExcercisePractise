package com.skillovilla.java_advanced.assignment3.level11;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentGradesReport {
    public Map<String, Double> calculateAverageGrades(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                Student::getName,
                student -> student.getSubjects().stream()
                        .mapToDouble(Subject::getGrade)
                        .average()
                        .orElse(0.0)
        ));
    }
}
