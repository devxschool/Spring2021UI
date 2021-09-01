package pojo;

import utils.AccountOwnership;
import utils.AccountType;

public class NewCheckingDataContainer {
    private AccountType accountType;
    private AccountOwnership accountOwnership;
    private String accountName;
    private double initialDeposit;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountOwnership getAccountOwnership() {
        return accountOwnership;
    }

    public void setAccountOwnership(AccountOwnership accountOwnership) {
        this.accountOwnership = accountOwnership;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    @Override
    public String toString() {
        return "NewCheckingDataContainer{" +
                "accountType='" + accountType + '\'' +
                ", accountOwnership='" + accountOwnership + '\'' +
                ", accountName='" + accountName + '\'' +
                ", initialDeposit=" + initialDeposit +
                '}';
    }
}
