package mThreading.wait;

import mThreading.wait.task1.SimpleBlockingQueue;
import org.apache.log4j.Logger;
import org.junit.Test;

public class SimpleBlockingQueueTest {
    private SimpleBlockingQueue<Integer> testQueue = new SimpleBlockingQueue<Integer>();
    final static Logger logger = Logger.getLogger(SimpleBlockingQueueTest.class);

    @Test
    public void ShouldCorrectlyPollAndPush() {
        Thread producer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < 1000; i++) {
                    testQueue.offer(i);
                }
            }
        });
        Thread producer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1000; i < 2000; i++) {
                    testQueue.offer(i);
                }
            }
        });
        Thread producer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=2000; i < 3000; i++) {
                    testQueue.offer(i);
                }
            }
        });
        Thread consumer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("start consumer 1");
                for (int i=1; i < 3000; i++) {
                    logger.info(i);
                    try {
                        logger.info("poll");
                        testQueue.poll();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("start consumer 2");
                for (int i=1; i < 3000; i++) {
                    try {
                        testQueue.poll();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1; i < 3000; i++) {
                    try {
                        testQueue.poll();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        consumer1.start();
        consumer2.start();
       // consumer3.start();

       // producer1.start();
       // producer2.start();
       // producer3.start();
    }

}