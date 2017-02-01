package com.company;

import java.util.Random;

/**
 * Created by Someone on 30.01.2017.
 */
public class Decreaser extends Thread {
    Card card;

    Decreaser(Card card, String threadName) {
        super(threadName);
        this.card = card;
        this.setPriority(MIN_PRIORITY);
        start();
    }

    public void run() {
        Random random = new Random();
        int count = 0;
        try {
            System.out.println("Thread " + getName() + "starting");
            do {
                card.decreaseBalance(random.nextInt(50));
                count++;
            }
            while (!card.stop && count < 500000);
            card.stop = true;
        }
        catch (Exception interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println("Thread" + getName() + " terminating AFTER " + count + " operations");
    }
}
