package com.skillovilla.java_advanced.assignment3.level11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level14Test {

    private Class<?> studentGradesReportClass;
    private Object studentGradesReportInstance;

    @BeforeEach
    void setUp() throws Exception {
        studentGradesReportClass = Class.forName("com.skillovilla.java_advanced.assignment3.level11.StudentGradesReport");
        studentGradesReportInstance = studentGradesReportClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testCalculateAverageGrades() throws Exception {
        Method calculateAverageGradesMethod = studentGradesReportClass.getMethod("calculateAverageGrades", List.class);

        List<Student> students = Arrays.asList(
            new Student("Alice", Arrays.asList(
                new Subject("Math", 90),
                new Subject("Science", 80)
            )),
            new Student("Bob", Arrays.asList(
                new Subject("Math", 85),
                new Subject("Science", 75),
                new Subject("English", 70)
            ))
        );

        Map<String, Double> result = (Map<String, Double>) calculateAverageGradesMethod.invoke(studentGradesReportInstance, students);

        assertEquals(85.0, result.get("Alice"));
        assertEquals(76.66666666666667, result.get("Bob"), 0.0001);
    }
}
