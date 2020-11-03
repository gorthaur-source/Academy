package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        BQueue<Integer> queue= new BQueue<>(10);

        Producer p1 = new Producer(queue,100);
        Thread t1 = new Thread(p1, "Edgar Produtor");

        Producer p2 = new Producer(queue,100);
        Thread t2 = new Thread(p2,"Bruno Produtor");

        Consumer c1 = new Consumer(queue, 100);
        Thread t3 = new Thread(c1, "João Consumidor");

        Consumer c2 = new Consumer(queue, 100);
        Thread t4 = new Thread(c2, "Juliana Consumidor");

        t3.start();
        t4.start();

        t1.start();
        t2.start();

    }

}

