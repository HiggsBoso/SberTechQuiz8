package com.company;

import java.util.Objects;
import java.util.function.ObjDoubleConsumer;

/**
 * Created by Someone on 30.01.2017.
 */
public class SequentialCard {
    //Object object = new Object();
    String cardNumber;
    int cardBalance;
    String state;

    public SequentialCard(String cardNumber) {
        this.cardNumber = cardNumber;
        cardBalance = 0;
        state = "decreased";
    }

    public synchronized void increaseBalance(int amount) {
        cardBalance+=amount;
        System.out.println("Card balance has been increased on " + amount);
        state = "increased";
        notify();
        try {
            while (!state.equals("decreased")) {
                wait();
            }
        }
        catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
    }

    public synchronized void decreaseBalance(int amount) {
        if (cardBalance < amount) {
            System.out.println("You are trying to get " + amount + " amount of money, but it's impossible " +
                    "to perform operation since there is not enough money on the card. Current balance is "
                    + getCardBalance());
        }
        else {
            cardBalance-=amount;
            System.out.println("Card balance has been decreased on " + amount + " amount of money");
        }
        state = "decreased";
        notify();
        try {
            while (!state.equals("increased")) {
                wait();
            }
        }
        catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }

    }

    public synchronized int getCardBalance() {
        return cardBalance;
    }
}
