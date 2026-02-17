package com.kodilla.school;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradesTestSuite {

    @Test
    public void shouldHaveZeroLength() {
        Grades grades = new Grades();
        assertEquals(0, grades.getValues().length);
    }

    @Test
    public void shouldAddTwoElementsToArray() {
        Grades grades = new Grades();
        grades.add(4);
        grades.add(2);
        assertEquals(2, grades.getValues().length);
        assertEquals(4, grades.getValues()[0]);
    }

    @Test
    public void shouldCalculateAverage() {
        Grades grades = new Grades();
        grades.add(4);
        grades.add(2);
        grades.add(5);
        assertEquals(3.66, grades.getAverage(), 0.01);
    }

    @Test
    public void shouldReturnAverageEqualsZeroIsArrayIsEmpty() {
        Grades grades = new Grades();
        assertEquals(0, grades.getAverage(), 0.0001);
    }
}