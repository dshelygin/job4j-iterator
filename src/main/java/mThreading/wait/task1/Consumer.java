package mThreading.wait.task1;

import org.apache.log4j.Logger;

public class Consumer implements Runnable {
    private SimpleBlockingQueue<Integer> testQueue;
    private final String name;
    final static Logger logger = Logger.getLogger(Consumer.class);

    public Consumer(SimpleBlockingQueue<Integer> testQueue, String name) {
        this.testQueue = testQueue;
        this.name = name;
    }


    @Override
    public void run() {
        logger.info("started: " + name + " id:" +  Thread.currentThread().getId());
        for (int i=1; i < 10; i++) {
            try {
                logger.info(name + " poll:" + testQueue.poll());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
