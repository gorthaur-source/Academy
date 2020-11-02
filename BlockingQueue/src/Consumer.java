import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable
{
    protected BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    public void run() {
        try
        {
            while (true)
            {
                Object obj = queue.take();
                System.out.println("Consumed resource - Queue size now = "  + queue.size());
                take(obj);
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println("CONSUMER INTERRUPTED");
        }
    }

    void take(Object obj)
    {
        try
        {
            Thread.sleep(100); // simulate time passing
        }
        catch (InterruptedException ex)
        {
            System.out.println("Consumer Read INTERRUPTED");
        }
        System.out.println("Consuming object " + obj);
    }
}


package com.journaldev.concurrency;

        import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getMsg() !="exit"){
                Thread.sleep(10);
                System.out.println("Consumed "+msg.getMsg());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}