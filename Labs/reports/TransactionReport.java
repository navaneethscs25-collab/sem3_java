package reports;

import transaction.Account;

public class TransactionReport {
    public static void generateReport(Account account) {
        System.out.println("========================================");
        System.out.println("          TRANSACTION REPORT            ");
        System.out.println("========================================");
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.printf("Current Balance: Rs. %.2f\n", account.getBalance());
        System.out.println("Report Status  : Generated Successfully");
        System.out.println("========================================");
    }
}

