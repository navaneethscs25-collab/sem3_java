/*
Java 25/10/2026

Develop a Java program to create a package transaction containing a class Account 
with members Account Number and Balance. Include methods for deposit and withdrawal. 
Create another package reports containing a class to generate transaction reports. 
Import both packages into a main application.
*/

import transaction.Account;
import reports.TransactionReport;

class lab4 {
    public static void main(String[] args) {
        System.out.println("--- Banking Package Application Demo ---");

        // Creating Account object from package 'transaction'
        Account myAccount = new Account("SB-987654321", 5000.0);

        System.out.println("\nInitial State:");
        TransactionReport.generateReport(myAccount);

        // Performing Deposits
        System.out.println("\n--- Performing Transactions ---");
        myAccount.deposit(2500.0);
        myAccount.deposit(1000.0);

        // Performing Withdrawals
        myAccount.withdraw(3000.0);
        myAccount.withdraw(7000.0); // Exceeding balance demo

        // Generating report using package 'reports'
        System.out.println("\nFinal State:");
        TransactionReport.generateReport(myAccount);
    }
}

