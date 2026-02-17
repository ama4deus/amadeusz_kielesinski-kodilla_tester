package com.kodilla.bank.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTestSuite {

    @Test
    public void shouldAddTransactionsAndCalculateBalance() {
        // Given
        CashMachine cashMachine1 = new CashMachine();
        CashMachine cashMachine2 = new CashMachine();
        CashMachine[] cashMachines = {cashMachine1, cashMachine2};

        cashMachine1.addTransaction(200);
        cashMachine1.addTransaction(-50);
        cashMachine1.addTransaction(100);
        cashMachine2.addTransaction(2000);
        cashMachine2.addTransaction(-500);
        cashMachine2.addTransaction(1000);

        Bank bank = new Bank(cashMachines);

        // When
        int count = bank.getDepositCount() + bank.getWithdrawalCount();
        double balance = bank.getTotalBalance();

        // Then
        assertEquals(6, count);
        assertEquals(2750, balance);
    }

    @Test
    public void shouldReturnZeroForAveragesWhenNoTransactionsExist() {
        // Given - bankomaty bez żadnych transakcji
        CashMachine cashMachine = new CashMachine();
        Bank bank = new Bank(new CashMachine[]{cashMachine});

        // When & Then
        // Sprawdzamy, czy zabezpieczenie przed dzieleniem przez zero działa
        assertEquals(0, bank.getAverageDeposit(), 0.01);
        assertEquals(0, bank.getAverageWithdrawal(), 0.01);
    }

    @Test
    public void shouldCalculateCorrectAverages() {
        // Given
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(100);  // wpłata 1
        cashMachine.addTransaction(200);  // wpłata 2
        cashMachine.addTransaction(-100); // wypłata 1

        Bank bank = new Bank(new CashMachine[]{cashMachine});

        // When
        double avgDeposit = bank.getAverageDeposit();      // (100 + 200) / 2 = 150
        double avgWithdrawal = bank.getAverageWithdrawal(); // -100 / 1 = -100

        // Then
        assertEquals(150.0, avgDeposit, 0.01);
        assertEquals(-100.0, avgWithdrawal, 0.01);
    }

    @Test
    public void shouldCalculateCorrectCounts() {
        // Given
        CashMachine cashMachine = new CashMachine();
        cashMachine.addTransaction(100);
        cashMachine.addTransaction(-50);
        cashMachine.addTransaction(-150);

        Bank bank = new Bank(new CashMachine[]{cashMachine});

        // When & Then
        assertEquals(1, bank.getDepositCount());
        assertEquals(2, bank.getWithdrawalCount());
    }
}