package com.kodilla.collections.adv.maps.complex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

class ComplexMapTestSuite {
    @Test
    void testGradesAverage() {
        Grades grades = new Grades(5.0, 4.0, 3.0);
        assertEquals(4.0, grades.getAverage(), 0.001);
    }

    @Test
    void testStudentMap() {
        Map<Student, Grades> school = new HashMap<>();
        Student student = new Student("John", "Doe");
        Grades grades = new Grades(5.0, 5.0);

        school.put(student, grades);

        assertEquals(grades, school.get(new Student("John", "Doe")));
    }
}