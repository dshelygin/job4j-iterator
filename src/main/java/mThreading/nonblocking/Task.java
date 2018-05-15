package mThreading.nonblocking;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private AtomicInteger  version = new AtomicInteger(0);
    private String taskDescription;

    public int getVersion() {
        return version.get();
    }

    public int increaseVersion() {
        return this.version.getAndIncrement();
    }

    public String getTask() {
        return taskDescription;
    }

    public void setTask(String task) {
        this.taskDescription = task;
    }
}
