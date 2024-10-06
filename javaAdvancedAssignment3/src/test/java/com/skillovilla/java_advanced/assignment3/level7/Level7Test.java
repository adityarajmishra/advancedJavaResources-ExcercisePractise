package com.skillovilla.java_advanced.assignment3.level7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Level7Test {

    private Class<?> studentFilterClass;
    private Object studentFilterInstance;

    @BeforeEach
    void setUp() throws Exception {
        studentFilterClass = Class.forName("com.skillovilla.java_advanced.assignment3.level7.StudentFilter");
        studentFilterInstance = studentFilterClass.getDeclaredConstructor().newInstance();
    }

    @Test
    void testFilterByGrade() throws Exception {
        Method filterByGradeMethod = studentFilterClass.getMethod("filterByGrade", List.class, double.class);
        List<Student> students = Arrays.asList(
            new Student("Alice", 85.0),
            new Student("Bob", 70.0),
            new Student("Charlie", 90.0)
        );
        List<Student> result = (List<Student>) filterByGradeMethod.invoke(studentFilterInstance, students, 80.0);
        
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Charlie", result.get(1).getName());
    }

    @Test
    void testGetHonorStudents() throws Exception {
        Method getHonorStudentsMethod = studentFilterClass.getMethod("getHonorStudents", List.class, double.class);
        List<Student> students = Arrays.asList(
            new Student("Alice", 85.0),
            new Student("Bob", 70.0),
            new Student("Charlie", 90.0)
        );
        List<String> result = (List<String>) getHonorStudentsMethod.invoke(studentFilterInstance, students, 80.0);
        
        assertEquals(Arrays.asList("Alice", "Charlie"), result);
    }
}
