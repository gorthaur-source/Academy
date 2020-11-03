package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

        for(int i = 0; i < elementNum; i++) {

            try {
                Thread.sleep(1000 + (long) (Math.random() * 500));
                queue.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}