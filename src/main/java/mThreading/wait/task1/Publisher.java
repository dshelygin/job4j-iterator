package mThreading.wait.task1;

import org.apache.log4j.Logger;

public class Publisher implements Runnable {
    private SimpleBlockingQueue<Integer> testQueue;
    private final String name;
    final static Logger logger = Logger.getLogger(Publisher.class);

    public Publisher(SimpleBlockingQueue<Integer> testQueue, String name) {
        this.testQueue = testQueue;
        this.name = name;
    }

    @Override
    public void run() {
        logger.info("started: " + name + " id:" +  Thread.currentThread().getId());
        for (int i=0; i < 30; i++) {
            try {
                Thread.sleep(30);  //притормозим заполнение очереди
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            logger.info(name + " offer:" + i);
            testQueue.offer(i);
        }

    }
}
