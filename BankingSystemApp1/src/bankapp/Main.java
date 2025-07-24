package bankapp;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create Branch
        BankBranch branch = new BankBranch("B001", "Main Branch");

        // Step 2: Create Customer
        Customer c1 = new Customer("C001", "Alice");
        branch.addCustomer(c1);

        // Step 3: Create Accounts
        SavingsAccount sa = new SavingsAccount("S001", 5000.0);
        CurrentAccount ca = new CurrentAccount("C001", 2000.0);
        c1.addAccount(sa);
        c1.addAccount(ca);

        // Step 4: Deposit in Savings
        sa.deposit(2000.0);

        // Step 5: Withdraw from Current
        ca.withdraw(2500.0);

        // Step 6: Transfer from Savings to Current
        sa.transfer(ca, 1000.0);

        // Step 7: Show Transaction History
        System.out.println();
        sa.showTransactionHistory();
        System.out.println();
        ca.showTransactionHistory();
    }
}
