package mThreading.wait.task1;

import org.apache.log4j.Logger;

/**
 *  main class for task 1 (blocking queue)
 */

public class ConsumerPublisher {
    private static SimpleBlockingQueue<Integer> testQueue = new SimpleBlockingQueue<Integer>();
    final static Logger logger = Logger.getLogger(ConsumerPublisher.class);

    public static void main(String args[]) {
        Thread producer1 = new Thread(new Publisher(testQueue,"producer1"));
        Thread producer2 = new Thread(new Publisher(testQueue,"producer2"));
        Thread producer3 = new Thread(new Publisher(testQueue,"producer3"));


        Thread consumer1 = new Thread(new Consumer(testQueue,"consumer1"));
        Thread consumer2 = new Thread(new Consumer(testQueue,"consumer2"));
        Thread consumer3 = new Thread(new Consumer(testQueue,"consumer3"));

        consumer1.start();
        consumer2.start();
        consumer3.start();

        producer1.start();
        //producer2.start();
        //producer3.start();
    }
}
