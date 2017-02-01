package com.company;

/**
 * Created by Someone on 01.02.2017.
 */
public class AsyncAccount implements Account {
    int balance = 50;
    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void withdraw(int sum) {
        balance=-sum;
    }
}
