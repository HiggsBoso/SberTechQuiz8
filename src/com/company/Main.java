package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1 starting");
        Card card = new Card("123456");
        Increaser increaser = new Increaser(card, "Increaser thread");
        Decreaser decreaser = new Decreaser(card, "Decreaser thread");
        try {
            increaser.join();
            decreaser.join();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }


        System.out.println();
        System.out.println("Task 2 starting");

        SequentialCard sequentialCard = new SequentialCard("123456");
        SequentialIncreaser sequentialIncreaser = new SequentialIncreaser("Increaser thread", sequentialCard);
        SequentialDecreaser sequentialDecreaser = new SequentialDecreaser("Decreaser thread", sequentialCard);

        try {
            sequentialIncreaser.thread.join();
            sequentialDecreaser.thread.join();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }

        // Как можно использовать этот декоратор
        Account account = new SyncAccount(new AsyncAccount());

        System.out.println("Main thread ending");
    }
}
