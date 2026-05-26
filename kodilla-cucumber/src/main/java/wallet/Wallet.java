package wallet;

public class Wallet {
    private int balance = 0;
    private String lastMessage = "";

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public void debit(int amount) {
        this.balance -= amount;
    }

    public void setLastMessage(String message) {
        this.lastMessage = message;
    }

    public String getLastMessage() {
        return this.lastMessage;
    }
}