package com.smart;

public class Thread1 implements Runnable {
    private Bank bank;

    public Thread1(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.inc();
    }
}
