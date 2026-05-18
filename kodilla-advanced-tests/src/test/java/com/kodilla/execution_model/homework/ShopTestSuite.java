package com.kodilla.execution_model.homework;

import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ShopTestSuite {
    private Shop shop = new Shop();
    private Order o1 = new Order(100.0, LocalDate.of(2023, 1, 10), "user1");
    private Order o2 = new Order(250.5, LocalDate.of(2023, 5, 20), "user2");
    private Order o3 = new Order(50.0, LocalDate.of(2023, 12, 5), "user3");

    @Test
    public void shouldAddOrdersAndCheckCount() {
        //When
        int count = shop.getOrdersCount();
        //Then
        assertEquals(3, count);
    }

    @Test
    public void shouldNotAddDuplicateOrders() {
        //When
        shop.addOrder(new Order(100.0, LocalDate.of(2023, 1, 10), "user1"));
        //Then
        assertEquals(3, shop.getOrdersCount());
    }

    @Test
    public void shouldGetOrdersBetweenDates() {
        //When
        List<Order> result = shop.getOrdersBetweenDates(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 6, 1));
        //Then
        assertEquals(2, result.size());
    }

    @Test
    public void shouldReturnEmptyListWhenNoOrdersInDateRange() {
        //When
        List<Order> result = shop.getOrdersBetweenDates(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31));
        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldGetOrdersByValueRange() {
        //When
        List<Order> result = shop.getOrdersByValueRange(40.0, 150.0);
        //Then
        assertEquals(2, result.size());
    }

    @Test
    public void shouldCalculateTotalValue() {
        //When
        double total = shop.getTotalValue();
        //Then
        assertEquals(400.5, total, 0.01);
    }

    @Test
    public void shouldHandleEmptyShop() {
        //Given
        Shop emptyShop = new Shop();
        //Then
        assertEquals(0, emptyShop.getOrdersCount());
        assertEquals(0.0, emptyShop.getTotalValue());
    }

    @BeforeEach
    public void initializeShop() {
        shop.addOrder(o1);
        shop.addOrder(o2);
        shop.addOrder(o3);
    }
}