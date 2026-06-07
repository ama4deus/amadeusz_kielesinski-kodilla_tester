package wallet;

public class Cashier {
    private final CashSlot cashSlot;

    public Cashier(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdraw(Wallet wallet, int amount) {
        if (amount <= 0) {
            cashSlot.dispense(0);
            return;
        }
        if (wallet.getBalance() >= amount) {
            cashSlot.dispense(amount);
            wallet.setBalance(wallet.getBalance() - amount);
        } else {
            cashSlot.dispense(0);
            wallet.setLastMessage("I don't have enough money in my wallet");
        }
    }
}