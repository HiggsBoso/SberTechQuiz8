package com.company;

/**
 * Created by Someone on 01.02.2017.
 */
public class SyncAccount extends SyncDecorator {
    SyncAccount(Account account) {
        super(account);
    }

    @Override
    public void withdraw(int sum) {
        synchronized (this) {
            if (account.getBalance()>sum) {
                account.withdraw(sum);
            }
            else {
                System.out.print("Not enough money on the balance");
            }
        }
    }
}
