package com.kodilla.school;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTestSuite {

    @Test
    public void shouldCalculateCorrectAveragesIfValuesAreInRange() {
        Student student = new Student("Martin");
        student.addGeographyGrade(4);
        student.addGeographyGrade(4);
        student.addGeographyGrade(2);
        student.addHistoryGrade(1);
        student.addHistoryGrade(5);

        assertEquals(3.33, student.getGeographyAverage(), 0.01);
        assertEquals(3, student.getHistoryAverage(), 0.01);
        assertEquals(0, student.getMathsAverage(), 0.01);
    }

    @Test
    public void shouldCalculateAveragesIfValuesAreOutsideRange() {
        Student student = new Student("Martin");
        student.addGeographyGrade(-2); // odrzucona
        student.addGeographyGrade(4);
        student.addGeographyGrade(8);  // odrzucona
        student.addPhysicsGrade(3);

        assertEquals(4, student.getGeographyAverage(), 0.01);
        assertEquals(3, student.getPhysicsAverage(), 0.01);
    }

    @Test
    public void averageShouldBeZeroIfStudentDontHaveGrades() {
        Student student = new Student("Martin");
        assertEquals(0, student.getAverage(), 0.0001);
    }

    @Test
    public void shouldCalculateStudentAverage() {
        Student student = new Student("Martin");
        student.addGeographyGrade(4);
        student.addHistoryGrade(2);
        student.addMathGrade(5);
        student.addPhysicsGrade(3);
        // (4+2+5+3) / 4 = 14 / 4 = 3.5
        assertEquals(3.5, student.getAverage(), 0.001);
    }
}