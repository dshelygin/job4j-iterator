package mThreading.jmm;

import org.apache.log4j.Logger;

public class JMMCollisions {
    final static Logger logger = Logger.getLogger(JMMCollisions.class);

    public static void main(String args []) {

        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterIncreaser(counter, "1"));
        Thread thread2 = new Thread(new CounterIncreaser(counter, "2"));
        Thread thread3 = new Thread(new CounterIncreaser(counter, "3"));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }

        //should be 3000 but it is less
        logger.info("final counter:" + counter.getValue());

    }

}
