package transaction;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: Rs. %.2f | New Balance: Rs. %.2f\n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.printf("Insufficient balance! Cannot withdraw Rs. %.2f (Available: Rs. %.2f)\n", amount, balance);
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: Rs. %.2f | Remaining Balance: Rs. %.2f\n", amount, balance);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

