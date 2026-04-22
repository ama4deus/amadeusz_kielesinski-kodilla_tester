package com.kodilla.exception.homework;

public class WarehouseApp {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        warehouse.addOrder(new Order("ORD/2024/001"));
        warehouse.addOrder(new Order("ORD/2024/002"));
        warehouse.addOrder(new Order("ORD/2024/005"));

        try {
            Order result = warehouse.getOrder("ORD/999/NON-EXISTENT");
            System.out.println("Znaleziono zamówienie: " + result.getNumber());
        } catch (OrderDoesntExistException e) {
            System.out.println("Błąd: " + e.getMessage());
        } finally {
            System.out.println("Proces wyszukiwania zakończony.");
        }
    }
}