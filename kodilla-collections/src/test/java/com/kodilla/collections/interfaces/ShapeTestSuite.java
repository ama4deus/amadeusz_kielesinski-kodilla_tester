package com.kodilla.collections.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTestSuite {

    @Test
    void testAllShapes() {
        // 1. Circle
        Circle circle = new Circle(5.0);
        assertEquals(Math.PI * 25, circle.getArea());
        assertEquals(10 * Math.PI, circle.getPerimeter());
        assertEquals(new Circle(5.0), circle);

        // 2. Square
        Square square = new Square(10.0);
        assertEquals(100.0, square.getArea());
        assertEquals(40.0, square.getPerimeter());
        assertEquals(new Square(10.0), square);
        assertNotNull(square.toString()); // To odhaczy metodę toString()

        // 3. Triangle
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        assertEquals(6.0, triangle.getArea());
        assertEquals(12.0, triangle.getPerimeter());
        assertEquals(new Triangle(3.0, 4.0, 5.0), triangle);

        assertEquals(new Circle(5.0).hashCode(), circle.hashCode());
        assertEquals(new Square(10.0).hashCode(), square.hashCode());
        assertEquals(new Triangle(3.0, 4.0, 5.0).hashCode(), triangle.hashCode());
    }

    @Test
    void testInterfacesDemo() {
        assertDoesNotThrow(() -> InterfacesDemo.main(new String[]{}));
    }
}