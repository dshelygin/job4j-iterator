package mThreading.nonblocking;

public class OptimisticException extends Exception {
    public OptimisticException() {
        super("task was changed concurrently");
    }
}
