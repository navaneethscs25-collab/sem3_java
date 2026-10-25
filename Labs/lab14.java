/*
Java 25/10/2026

Lab 14: CIE Lab Test-2
Title: Multi-threaded Banking Transaction and Fund Transfer System

Problem Statement:
Develop a Java program to simulate a Concurrent Banking Transaction System:
1. Create a custom exception MinimumBalanceException thrown when balance falls below Rs. 1000.
2. Create a class BankAccount with members accountNumber, accountHolder, and balance.
   Implement synchronized methods:
   - deposit(double amount)
   - withdraw(double amount) throws MinimumBalanceException
   - transfer(BankAccount destination, double amount)
3. Create a thread class TransactionTask that performs concurrent deposit/withdrawal 
   operations on the shared account.
4. In main (lab14):
   - Instantiate shared accounts and multiple concurrent transaction threads.
   - Demonstrate synchronized access preventing race conditions, handling MinimumBalanceException,
     and showing final audited balances.
*/

class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private static final double MIN_BALANCE = 1000.0;

    BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.printf("[+] %s deposited Rs. %.2f | Current Balance: Rs. %.2f\n", 
            accountHolder, amount, balance);
    }

    public synchronized void withdraw(String clientName, double amount) throws MinimumBalanceException {
        System.out.printf("[-] %s attempting to withdraw Rs. %.2f from %s's account...\n", 
            clientName, amount, accountHolder);

        if ((balance - amount) < MIN_BALANCE) {
            throw new MinimumBalanceException("Withdrawal of Rs. " + amount + 
                " denied! Balance cannot fall below minimum limit of Rs. " + MIN_BALANCE + 
                " (Current: Rs. " + balance + ")");
        }

        balance -= amount;
        System.out.printf("[SUCCESS] %s withdrew Rs. %.2f | New Balance: Rs. %.2f\n", 
            clientName, amount, balance);
    }

    public synchronized void display() {
        System.out.printf("Account: %-12s | Holder: %-15s | Balance: Rs. %.2f\n", 
            accountNumber, accountHolder, balance);
    }
}

class ClientTransactionThread extends Thread {
    private BankAccount account;
    private String clientName;
    private double withdrawAmount;

    ClientTransactionThread(BankAccount account, String clientName, double withdrawAmount) {
        this.account = account;
        this.clientName = clientName;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        try {
            account.withdraw(clientName, withdrawAmount);
        } catch (MinimumBalanceException e) {
            System.out.println("[REJECTED] " + e.getMessage());
        }
    }
}

class lab14 {
    public static void main(String[] args) {
        System.out.println("=== CIE Lab Test - 2 Evaluation: Multi-threaded Banking System ===");

        // Shared Bank Account with initial Rs. 5000
        BankAccount sharedAccount = new BankAccount("SB-100234", "Joint Account (Alice & Bob)", 5000.0);

        System.out.println("\n--- Initial Account State ---");
        sharedAccount.display();

        System.out.println("\n--- Concurrent Withdrawals Starting ---");
        // Two concurrent clients attempting to withdraw
        ClientTransactionThread t1 = new ClientTransactionThread(sharedAccount, "Alice (ATM)", 2500.0);
        ClientTransactionThread t2 = new ClientTransactionThread(sharedAccount, "Bob (Online)", 2000.0);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Testing Single Attempt Exceeding Minimum Balance ---");
        try {
            sharedAccount.withdraw("Alice (Counter)", 1000.0);
        } catch (MinimumBalanceException e) {
            System.out.println("[REJECTED] " + e.getMessage());
        }

        System.out.println("\n--- Deposit Transaction ---");
        sharedAccount.deposit(3000.0);

        System.out.println("\n--- Final Audited Account State ---");
        sharedAccount.display();
    }
}

