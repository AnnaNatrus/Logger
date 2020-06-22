package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DebitAccount extends BankAccount {

    private static final Logger log = LogManager.getLogger(DebitAccount.class.getName());

    double payfee;
    double wlimit;
    double restbalance;

    public void checkBalance() throws IllegalArgumentException {
        if (balance < 0) {
            log.warn("Negative balance impossible for Debit operation.");
            throw new IllegalArgumentException("Balance cannot have negative amount. This is Debit account");
        }
        if (balance == 0) {
            log.warn("Cannot withdraw money with zero balance.");
            throw new IllegalArgumentException("Your balance is '0'. Please replenish your balance.");
        }
    }

    public void checkWithdraw() throws IllegalArgumentException {
        if (withdr < 0) {
            log.error("Debit operation failed. Amount with negative value was entered.");
            throw new IllegalArgumentException("Withdraw cannot have negative amount. Please enter new value.");
        }
    }

    public void paymentFee() {
        payfee = withdr * 0.01;
    }

    public double withdrawLimit() {
        wlimit = balance - payfee;
        return wlimit;
    }

    public void withdraw() {
        if (balance <= 0.0) {
            System.out.println("You cannot withdraw money.");
        } else if (withdr > wlimit) {
            log.warn("Withdraw > than withdraw limit");
            System.out.println("Your withdraw > than withdraw limit. Please enter new value");
        } else {
            log.info("All values entered.");
            System.out.println("You can withdraw this amount: " + withdr);
        }
    }

    public void restBalance() {
        if (balance > 0 && withdr <= wlimit)
            restbalance = balance - withdr - payfee;
        else restbalance = balance;
    }

    public void printResult() {
        if (withdr > wlimit && balance > 0) {
            System.out.println("Your balance is: " + balance);
            System.out.println("Please leave money for Payment Fee (1%)");
        } else if (withdr > wlimit && balance <= 0) {
            System.out.println("Payment Fee is (1%)");
        } else {
            log.info("Success operation.");
            System.out.println("Your balance is: " + balance);
            System.out.println("Payment Fee (1%) is: " + payfee);
            System.out.println("Your balance after withdraw is: " + restbalance);
        }
    }
}