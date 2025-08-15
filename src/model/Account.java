package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Serializable {
    private String accountNumber;
    private String holderName;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
    public List<Transaction> getTransactions() { return transactions; }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public abstract String getAccountType();

    @Override
    public String toString() {
        return getAccountType() + " Account [" + accountNumber + "] - " + holderName + " | Balance: " + balance;
    }
}
