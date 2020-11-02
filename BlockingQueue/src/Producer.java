import java.util.concurrent.BlockingQueue;

class Producer implements Runnable
{
    protected BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    public void run()
    {
        try
        {
            while (true)
            {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("Produced resource - Queue size now = "  + queue.size());
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println("Producer INTERRUPTED");
        }
    }

    Object getResource()
    {
        try
        {
            Thread.sleep(100); // simulate time passing during read
        }
        catch (InterruptedException ex)
        {
            System.out.println("Producer Read INTERRUPTED");
        }
        return new Object();
    }
}



package com.journaldev.concurrency;

        import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=0; i<100; i++){
            Message msg = new Message(""+i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


