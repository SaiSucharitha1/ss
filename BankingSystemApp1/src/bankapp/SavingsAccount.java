package bankapp;

public class SavingsAccount extends Account {
    private final double MIN_BALANCE = 1000.0;

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
        addTransaction("Savings Account opened with balance: ₹" + initialBalance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: ₹" + amount);
        System.out.println("➡ Deposited ₹" + amount + " to Savings Account [" + accountNumber + "]");
        System.out.println("📌 Current Balance: ₹" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            addTransaction("Withdrawn: ₹" + amount);
            System.out.println("✅ Withdrawn ₹" + amount + " from Savings Account [" + accountNumber + "]");
            System.out.println("📌 Current Balance: ₹" + balance);
        } else {
            System.out.println("❌ Cannot withdraw. Minimum balance ₹" + MIN_BALANCE + " must be maintained.");
        }
    }
}

