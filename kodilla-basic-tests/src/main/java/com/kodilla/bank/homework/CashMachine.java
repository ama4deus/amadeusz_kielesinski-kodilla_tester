package com.kodilla.bank.homework;

import java.util.Arrays;

public class CashMachine {
    private double[] transactions;

    public CashMachine() {
        this.transactions = new double[0];
    }

    public void addTransaction(double amount) {
        if (amount == 0) return; // Opcjonalne zabezpieczenie przed pustymi transakcjami
        this.transactions = Arrays.copyOf(this.transactions, this.transactions.length + 1);
        this.transactions[this.transactions.length - 1] = amount;
    }

    public int getTransactionsCount() {
        return this.transactions.length;
    }

    public double getBalance() {
        double sum = 0;
        for (int i = 0; i < transactions.length; i++) {
            sum = sum + transactions[i];
        }
        return sum;
    }

    public double[] getTransactions() {
        return transactions;
    }
}