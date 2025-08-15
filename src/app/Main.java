package app;

import model.Account;
import service.BankService;
import service.TransactionService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        TransactionService transactionService = new TransactionService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View All Accounts");
            System.out.println("6. View Transactions");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Account No: ");
                    String accNo = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("Interest Rate: ");
                    double rate = sc.nextDouble();
                    bankService.createSavingsAccount(accNo, name, bal, rate);
                }
                case 2 -> {
                    System.out.print("Account No: ");
                    String accNo = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("Overdraft Limit: ");
                    double limit = sc.nextDouble();
                    bankService.createCurrentAccount(accNo, name, bal, limit);
                }
                case 3 -> {
                    System.out.print("Account No: ");
                    String accNo = sc.nextLine();
                    Account acc = bankService.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        transactionService.deposit(acc, amt);
                        bankService.save();
                    } else {
                        System.out.println("Account not found!");
                    }
                }
                case 4 -> {
                    System.out.print("Account No: ");
                    String accNo = sc.nextLine();
                    Account acc = bankService.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Amount: ");
                        double amt = sc.nextDouble();
                        if (transactionService.withdraw(acc, amt)) {
                            bankService.save();
                        } else {
                            System.out.println("Insufficient balance!");
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                }
                case 5 -> bankService.viewAllAccounts();
                case 6 -> {
                    System.out.print("Account No: ");
                    String accNo = sc.nextLine();
                    Account acc = bankService.getAccount(accNo);
                    if (acc != null) {
                        transactionService.printTransactions(acc);
                    } else {
                        System.out.println("Account not found!");
                    }
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
