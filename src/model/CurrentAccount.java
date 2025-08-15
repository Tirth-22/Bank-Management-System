package model;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "Current";
    }

    public double getOverdraftLimit() { return overdraftLimit; }
}
