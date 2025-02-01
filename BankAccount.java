package src;
public class BankAccount {
    public double balance;
    public StringBuilder transactionHistory;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new StringBuilder("Transaction History:\n");
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.append("Deposited: ").append(amount).append("\n");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.append("Withdrawn: ").append(amount).append("\n");
            return true;
        }
        return false;
    }

    public String getTransactionHistory() {
        return transactionHistory.toString();
    }
}
