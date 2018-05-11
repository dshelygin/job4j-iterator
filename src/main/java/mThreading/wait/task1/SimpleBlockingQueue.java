package mThreading.wait.task1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @param <T>
 */

@ThreadSafe
public class SimpleBlockingQueue<T> {
    boolean wasSignaled = false;
    Object monitor = new Object();

    final static Logger logger = Logger.getLogger(SimpleBlockingQueue.class);

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public void offer(T value) {
        synchronized (monitor) {
            queue.offer(value);
            logger.info(String.format("%s notify", Thread.currentThread().getId()));
            wasSignaled = true;
            monitor.notify();
        }
    }

    public T poll() throws InterruptedException {

            synchronized (monitor) {
                if (queue.size() > 0 ) {
                    return queue.poll();
                } else {

                while (!wasSignaled) {
                    logger.info(String.format("%s waiting", Thread.currentThread().getId()));
                    monitor.wait();
                    logger.info(String.format("%s wait passed", Thread.currentThread().getId()));
                    wasSignaled = false;
                    return queue.poll();
                }
            }
        }
        return null;
    }
}
