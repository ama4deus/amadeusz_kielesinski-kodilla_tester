package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashMachineTestSuite {

    @Test
    public void shouldAddTransactionsAndCalculateBalance() {
        // Given
        CashMachine cashMachine = new CashMachine();

        // When
        cashMachine.addTransaction(200);
        cashMachine.addTransaction(-50);
        cashMachine.addTransaction(100);

        // Then
        assertEquals(3, cashMachine.getTransactionsCount());
        assertEquals(250, cashMachine.getBalance());
    }

    @Test
    public void shouldReturnZeroBalanceWhenNoTransactions() {
        // Given
        CashMachine cashMachine = new CashMachine();

        // When & Then
        assertEquals(0, cashMachine.getBalance());
        assertEquals(0, cashMachine.getTransactionsCount());
    }

    @Test
    public void shouldHandleNegativeTransactions() {
        // Given
        CashMachine cashMachine = new CashMachine();

        // When
        cashMachine.addTransaction(-100);
        cashMachine.addTransaction(-200);

        // Then
        assertEquals(-300, cashMachine.getBalance());
        assertEquals(2, cashMachine.getTransactionsCount());
    }
}