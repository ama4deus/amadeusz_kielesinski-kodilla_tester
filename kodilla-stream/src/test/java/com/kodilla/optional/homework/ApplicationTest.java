package com.kodilla.optional.homework;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void testOptionalWithTeacher() {
        // Given
        Teacher teacher = new Teacher("Tomasz Nowak");
        Student student = new Student("Jan Kowalski", teacher);

        // When
        Optional<Teacher> optionalTeacher = Optional.ofNullable(student.getTeacher());
        String result = optionalTeacher.map(Teacher::getName).orElse("<undefined>");

        // Then
        assertEquals("Tomasz Nowak", result);
    }

    @Test
    void testOptionalWithNullTeacher() {
        // Given
        Student student = new Student("Ania Bania", null);

        // When
        Optional<Teacher> optionalTeacher = Optional.ofNullable(student.getTeacher());
        String result = optionalTeacher.map(Teacher::getName).orElse("<undefined>");

        // Then
        assertEquals("<undefined>", result);
    }
}