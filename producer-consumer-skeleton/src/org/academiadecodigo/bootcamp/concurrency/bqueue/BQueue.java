package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {


    final private Integer limit;
    private LinkedList<T> queue = new LinkedList<>();
    private Integer currentSize;
    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */
    public BQueue(int limit) {

        if (limit <= 0) throw new IllegalArgumentException();
        this.limit = limit;
        currentSize = queue.size();


    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public void offer(T data) {

        synchronized (this) {

            while (queue.size() == getLimit()) {
              //  System.out.println("Queue is full. Waiting for consumer");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(data);
            System.out.println(Thread.currentThread() + " added element #" + queue.size());

            if(queue.size() == getLimit()) System.out.println("Halt! The queue is full");

            notifyAll();
        }


    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public T poll() {

            T removedElement = null;

            synchronized (this) {

                while (queue.size() == 0) {

                //    System.out.println("Queue is empty. Waiting for producer");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                removedElement = queue.poll();
                System.out.println(Thread.currentThread() + " consumed. Queue shrunk to size " + queue.size());
                if(queue.size() == 0) System.out.println("Halt! I've left the queue empty");
                notifyAll();
            }

            return removedElement;
    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public int getSize() {


        return queue.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {

        return limit;

    }

}
