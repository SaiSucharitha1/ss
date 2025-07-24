package bankapp;

public class CurrentAccount extends Account {
    private final double OVERDRAFT_LIMIT = 2000.0;

    public CurrentAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
        addTransaction("Current Account opened with balance: ₹" + initialBalance + " and overdraft limit ₹" + OVERDRAFT_LIMIT);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: ₹" + amount);
        System.out.println("➡ Deposited ₹" + amount + " to Current Account [" + accountNumber + "]");
        System.out.println("📌 Current Balance: ₹" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if ((balance - amount) >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            addTransaction("Withdrawn: ₹" + amount);
            System.out.println("✅ Withdrawn ₹" + amount + " from Current Account [" + accountNumber + "]");
            System.out.println("📌 Current Balance: ₹" + balance);
        } else {
            System.out.println("❌ Overdraft limit exceeded.");
        }
    }
}

