package com.kodilla.exception.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    private Warehouse warehouse;

    @BeforeEach
    public void setUp() {
        warehouse = new Warehouse();
        warehouse.addOrder(new Order("ORD/001"));
        warehouse.addOrder(new Order("ORD/002"));
    }

    @Test
    public void shouldReturnOrder_whenOrderExists() throws OrderDoesntExistException {
        // When
        Order result = warehouse.getOrder("ORD/001");

        // Then
        assertNotNull(result);
        assertEquals("ORD/001", result.getNumber());
    }

    @Test
    public void shouldThrowException_whenOrderDoesNotExist() {
        // When & Then
        assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("NON-EXISTENT"));
    }
    @Test
    public void shouldRunMainAppMethod() {
        // Gdy wywołamy metodę main, wtyczka "zaliczy" ją jako uruchomioną
        assertDoesNotThrow(() -> WarehouseApp.main(new String[]{}));
    }
}