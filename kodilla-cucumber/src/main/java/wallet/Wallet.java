package wallet;

public class Wallet {
    private int balance = 0;
    private String lastMessage;

    public void deposit(int money) {
        if (money > 0) {
            this.balance += money;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}