package com.company;

/**
 * Created by Someone on 01.02.2017.
 */
public abstract class SyncDecorator implements Account {
    Account account;

    SyncDecorator(Account account) {
        this.account = account;
    }

    @Override
    public int getBalance() {
        return account.getBalance();
    }

    @Override
    public void withdraw(int sum) {
        account.withdraw(sum);
    }
}
