package com.kodilla.bank.homework;

public class Bank {
    private CashMachine[] machines;

    public Bank(CashMachine[] machines) {
        this.machines = machines;
    }

    public double getTotalBalance() {
        double totalSum = 0;
        for (int i = 0; i < machines.length; i++) {
            totalSum = totalSum + machines[i].getBalance();
        }
        return totalSum;
    }

    public int getWithdrawalCount() {
        int count = 0;
        for (int i = 0; i < machines.length; i++) {
            double[] trans = machines[i].getTransactions();

            for (int j = 0; j < trans.length; j++) {
                if (trans[j] < 0) {
                    count++; // Zwiększamy licznik, bo znaleźliśmy liczbę ujemną (wypłatę)
                }
            }
        }
        return count;
    }

    public int getDepositCount() {
        int count = 0;
        for (int i = 0; i < machines.length; i++) {
            double[] trans = machines[i].getTransactions();

            for (int j = 0; j < trans.length; j++) {
                if (trans[j] > 0) {
                    count++; // Zwiększamy licznik, bo znaleźliśmy liczbę dodatnią (wpłatę)
                }
            }
        }
        return count;
    }

    public double getAverageWithdrawal() {
        double sum = 0;
        int count = 0;

        for (int i = 0; i < machines.length; i++) {
            double[] trans = machines[i].getTransactions();
            for (int j = 0; j < trans.length; j++) {
                if (trans[j] < 0) {
                    sum = sum + trans[j];
                    count++;
                }
            }
        }

        if (count == 0) {
            return 0;
        }
        return sum / count;
    }

    public double getAverageDeposit() {
        double sum = 0;
        int count = 0;

        for (int i = 0; i < machines.length; i++) {
            double[] trans = machines[i].getTransactions();
            for (int j = 0; j < trans.length; j++) {
                if (trans[j] > 0) {
                    sum = sum + trans[j];
                    count++;
                }
            }
        }

        if (count == 0) {
            return 0;
        }
        return sum / count;
    }
}