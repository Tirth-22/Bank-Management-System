package model;

public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }

    public double getInterestRate() { return interestRate; }
}
