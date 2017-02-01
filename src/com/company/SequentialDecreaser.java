package com.company;

import java.util.Random;

/**
 * Created by Someone on 30.01.2017.
 */
public class SequentialDecreaser implements Runnable {
    Thread thread;
    SequentialCard card;

    SequentialDecreaser(String name, SequentialCard card) {
        thread = new Thread(this, name);
        this.card = card;
        thread.start();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            card.decreaseBalance(random.nextInt(50));
        }
    }
}
