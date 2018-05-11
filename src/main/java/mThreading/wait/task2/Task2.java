package mThreading.wait.task2;

import org.apache.log4j.Logger;

/**
 * main class for task 2
 */
public class Task2 {
    final static Logger logger = Logger.getLogger(Task2.class);

    public static void main(String args[]) {
        SimpleThreadPool threadPool = new SimpleThreadPool();

        for (int i=1; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    logger.info("started task in Thread:" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    logger.info("finished task in Thread:" + Thread.currentThread().getId());
                }
            });
        }


    }
}
