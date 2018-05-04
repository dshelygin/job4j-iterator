package mThreading.jmm;

import mThreading.threads.PingPong;
import org.apache.log4j.Logger;

public class CounterIncreaser implements Runnable {
    final static Logger logger = Logger.getLogger(CounterIncreaser.class);
    private Counter counter;
    private final String name;

    @Override
    public void run() {
        for (int i=0; i < 1000; i++) {
            this.counter.increase();
        }
        logger.info("Thread: " + this.name + " is finished, counter: " + this.counter.getValue() );
    }

    public CounterIncreaser(Counter counter, String name) {
        logger.info("thread:" + name + " created");
        this.counter = counter;
        this.name = name;
    }
}
