package com.smart;

public class Bank {
    public int account = 0;

     public void inc() {
        for (int i = 1; i <= 20000; i++) {
            account += 2;
        }
        System.out.println("Final account inc: " + account);
    }

     public void dec() {
        for (int i = 1; i <= 20000; i++) {
            account--;
        }
        System.out.println("Final account desc: " + account);
    }
}
