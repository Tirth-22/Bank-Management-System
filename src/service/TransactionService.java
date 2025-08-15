package service;

import model.Account;
import model.Transaction;

public class TransactionService {

    public void deposit(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        account.addTransaction(new Transaction("Deposit", amount));
    }

    public boolean withdraw(Account account, double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            account.addTransaction(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public void printTransactions(Account account) {
        account.getTransactions().forEach(System.out::println);
    }
}
