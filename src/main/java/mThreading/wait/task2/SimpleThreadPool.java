package mThreading.wait.task2;

import mThreading.wait.task1.SimpleBlockingQueue;
import org.apache.log4j.Logger;

import java.util.concurrent.Executor;

public class SimpleThreadPool implements Executor {
    private SimpleBlockingQueue<Runnable> taskQueue = new SimpleBlockingQueue<>();
    private boolean isStarted = true;
    final static Logger logger = Logger.getLogger(SimpleThreadPool.class);

    public SimpleThreadPool() {
        logger.info(String.format("starting %d threads", Runtime.getRuntime().availableProcessors()));
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++ ) {
            new Thread(new TaskWorker()).start();
        }
    }

    @Override
    public void execute(Runnable command) {
        taskQueue.offer(command);

    }

    public void shutdown() {
        this.isStarted = false;
    }

    private final class TaskWorker implements Runnable {
        @Override
        public void run() {
            while(isStarted) {
                try {
                    Runnable task = taskQueue.poll();
                    if (task != null ) {
                        logger.info("running task:" + task.toString());
                        task.run();
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }

}
