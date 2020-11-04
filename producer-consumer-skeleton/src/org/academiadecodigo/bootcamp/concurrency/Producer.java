package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

        for (int i = 0; i < elementNum; i++) {

            synchronized (queue) {
                queue.offer(i);
                if (queue.getSize() == queue.getLimit()) System.out.println(Thread.currentThread().getName() + ": Halt! The queue is full");
            }
            try {
                Thread.sleep(1500 + (long) (Math.random() * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
