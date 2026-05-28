package com.kodilla.collections.sets;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderTestSuite {

    @Test
    void testOrderSetLogic() {
        // Given
        Set<Order> orders = new HashSet<>();
        Order o1 = new Order("1/2019", "Iron", 1.0);
        Order o2 = new Order("2/2019", "Cutlery", 6.0);
        Order o3 = new Order("3/2019", "Chair", 2.0);
        Order o1Duplicate = new Order("1/2019", "Iron", 1.0);

        // When
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        orders.add(o1Duplicate); // To jest duplikat

        // Then
        assertEquals(3, orders.size()); // Sprawdzamy, czy rozmiar to 3 (a nie 4!)
    }

    @Test
    void testMainMethod() {
        assertDoesNotThrow(() -> OrderApplication.main(new String[]{}));
    }
}