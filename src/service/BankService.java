package service;

import model.*;
import util.FileUtil;

import java.util.*;

public class BankService {
    private Map<String, Account> accounts;
    private final String DATA_FILE = "bank_data.ser";

    public BankService() {
        accounts = FileUtil.loadData(DATA_FILE);
        if (accounts == null) {
            accounts = new HashMap<>();
        }
    }

    public void createSavingsAccount(String accNo, String name, double balance, double interestRate) {
        accounts.put(accNo, new SavingAccount(accNo, name, balance, interestRate));
        save();
    }

    public void createCurrentAccount(String accNo, String name, double balance, double overdraft) {
        accounts.put(accNo, new CurrentAccount(accNo, name, balance, overdraft));
        save();
    }

    public Account getAccount(String accNo) {
        return accounts.get(accNo);
    }

    public void save() {
        FileUtil.saveData(accounts, DATA_FILE);
    }

    public void viewAllAccounts() {
        accounts.values().forEach(System.out::println);
    }
}
