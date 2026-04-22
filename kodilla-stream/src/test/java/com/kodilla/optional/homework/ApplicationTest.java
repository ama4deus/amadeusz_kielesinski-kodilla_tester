package com.kodilla.optional.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void testGetTeacherNameWhenTeacherExists() {
        // Given
        Teacher teacher = new Teacher("Tomasz Nowak");
        Student student = new Student("Jan Kowalski", teacher);

        // When & Then
        assertEquals("Tomasz Nowak", student.getTeacherName());
    }

    @Test
    void testGetTeacherNameWhenTeacherIsNull() {
        // Given
        Student student = new Student("Ania Bania", null);

        // When & Then
        assertEquals("<undefined>", student.getTeacherName());
    }

    @Test
    void testTeacherGetName() {
        Teacher teacher = new Teacher("Jan Nowak");
        assertEquals("Jan Nowak", teacher.getName());
    }

    @Test
    void testStudentGetName() {
        Student student = new Student("Ania", null);
        assertEquals("Ania", student.getName());
    }
}