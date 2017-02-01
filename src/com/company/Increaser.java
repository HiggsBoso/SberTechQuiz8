package com.company;

import java.util.Random;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Someone on 30.01.2017.
 */
public class Increaser extends Thread {
    Card card;

    Increaser(Card card, String threadName) {
        super(threadName);
        this.card = card;
        this.setPriority(MAX_PRIORITY);
        start();
    }

    //@Override
    public void run() {
        Random random = new Random();
        int count = 0;
        try {
            System.out.println("Thread " + getName() + "starting");
            do {
                card.increaseBalance(random.nextInt(100));
                count++;
            }
            while (!card.stop && count < 500000);
            card.stop = true;
        }
        catch (Exception interruptedException) {
            interruptedException.printStackTrace();
        }
        System.out.println("Thread" + getName() + " terminating after " + count + " operations");
    }
}
