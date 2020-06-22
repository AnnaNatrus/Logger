package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("Started");

        System.out.println("Debit Account:");
        DebitAccount da = new DebitAccount();
        try {
            da.setBalance(5);
            da.checkBalance();
        } catch (IllegalArgumentException eb) {
            System.out.println(eb.getMessage());
        }
        try {
            da.setWithdraw(-10);
            da.checkWithdraw();
            da.paymentFee();
            da.withdrawLimit();
            da.withdraw();
            da.restBalance();
            da.printResult();
        } catch (IllegalArgumentException ew) {
            System.out.println(ew.getMessage());
        }
        System.out.println();

        System.out.println("Credit Account:");
        CreditAccount ca = new CreditAccount();
        ca.setBalance(0);
        try {
            ca.setCredLimit(8);
            ca.checkCreLimit();
        } catch (IllegalArgumentException el) {
            System.out.println(el.getMessage());
        }
        try {
            ca.setWithdraw(5);
            ca.checkWithdraw();

            ca.paymentFee();
            ca.withdrawLimit();
            ca.withdraw();
            ca.restBalance();
            ca.printResult();

        } catch (IllegalArgumentException ew) {
            System.out.println(ew.getMessage());
        }

        log.info("Finished");

    }

}

