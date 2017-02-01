package com.company;

/**
 * Created by Someone on 30.01.2017.
 */
public class Card {
    private String cardNumber;
    private int cardBalance;
    // This variable is used for stopping loop inside threads to show that thread with higher priority gets more CPU time
    // so it'll perform more before stoppage
    public boolean stop = false;

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
        cardBalance = 0;
    }

    public synchronized void increaseBalance(int amount) {
        cardBalance+=amount;
        System.out.println("Card balance has been increased on " + amount);
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
    }

    public synchronized int getCardBalance() {
        return cardBalance;
    }
}
