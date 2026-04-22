package com.kodilla.exception.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    void testGetOrder_withException() {
        // Given
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder(new Order("ORD/001"));

        // When & Then
        assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("ORD/999"));
    }
}