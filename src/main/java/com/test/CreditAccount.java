package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreditAccount extends BankAccount {

    private static final Logger log = LogManager.getLogger(CreditAccount.class.getName());

    double payfee;
    double wlimit;
    double restbalance;
    double crelimit;

    public void checkWithdraw() throws IllegalArgumentException {
        if (withdr < 0) {
            log.error("Credit operation failed. Amount with negative value was entered.");
            throw new IllegalArgumentException("Withdraw cannot have negative amount. Please enter new value.");
        }
    }

    public void setCredLimit(double crelimit) {
        this.crelimit = crelimit;
    }

    public double getCredLimit() {
        return crelimit;
    }

    public void checkCreLimit() throws IllegalArgumentException {
        if (crelimit < 0) {
            log.error("Credit operation failed. Credit limit with negative value was entered.");
            throw new IllegalArgumentException("Credit limit cannot have negative amount. Please enter new value.");
        }
    }

    public void paymentFee() {
        if (balance >= 0 && withdr <= balance)
            payfee = withdr * 0.01;
        else if (balance > 0 && withdr > balance)
            payfee = (balance * 0.01) + (withdr - balance) * 0.05;
        else if (balance <= 0 && withdr > balance)
            payfee = withdr * 0.05;
        else payfee = 0.0;
    }

    public double withdrawLimit() {
        wlimit = crelimit + balance - payfee;
        return wlimit;
    }

    public void withdraw() {
        if (withdr > wlimit && crelimit >= 0) {
            log.warn("Withdraw > than withdraw limit");
            System.out.println("your withdraw > than withdraw limit");
        } else if (crelimit < 0) {

        } else {
            log.info("All values entered.");
            System.out.println("You can withdraw this amount: " + withdr);
        }
    }

    public void restBalance() {
        if (withdr <= wlimit)
            restbalance = (balance + crelimit) - withdr - payfee;
        else restbalance = balance;
    }

    public void printResult() {
        if (crelimit < 0.0) {

        } else if (withdr > wlimit) {
            System.out.println("Your balance is: " + balance + "; Your credit limit is: " + crelimit);
            System.out.println("Total: " + (balance + crelimit));
            System.out.println("Please leave money for Payment Fee (1% for your money and 5% for credit money)");
        } else {
            log.info("Success operation.");
            System.out.println("Your balance is: " + balance);
            System.out.println("Your credit limit is: " + crelimit);
            System.out.println("Total: " + (balance + crelimit));
            System.out.println("Payment Fee is: " + payfee);
            System.out.println("Your total balance after withdraw is: " + restbalance);
        }
    }

}
