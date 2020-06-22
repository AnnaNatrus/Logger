package com.test;

public abstract class BankAccount {
    double balance;
    double withdr;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setWithdraw(double withdr) {
        this.withdr = withdr;
    }

    public double getWithdraw() {
        return withdr;
    }

    public abstract void withdraw();

    public abstract void paymentFee();

}
