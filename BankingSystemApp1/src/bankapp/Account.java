package bankapp;

import java.util.*;

public abstract class Account implements BankOperations {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void transfer(Account target, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            target.deposit(amount);
            addTransaction("Transferred to Account " + target.accountNumber + ": ₹" + amount);
            target.addTransaction("Received from Account " + this.accountNumber + ": ₹" + amount);
        } else {
            System.out.println("❌ Insufficient funds for transfer.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    protected void addTransaction(String info) {
        transactionHistory.add(info);
    }

    public void showTransactionHistory() {
        System.out.println("🔁 Transaction History for Account: " + accountNumber);
        for (String entry : transactionHistory) {
            System.out.println(" - " + entry);
        }
    }
}

