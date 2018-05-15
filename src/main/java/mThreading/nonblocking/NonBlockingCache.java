package mThreading.nonblocking;

import java.util.concurrent.ConcurrentHashMap;


public class NonBlockingCache {
    private ConcurrentHashMap<Integer,Task> localCache = new ConcurrentHashMap<Integer,Task>();

    public void  add(Integer taskId, Task task) {
        localCache.put(taskId,task);
    }

    public boolean update(Integer taskId, Task newTask) throws OptimisticException {

        Task task1 = localCache.computeIfPresent(taskId, (id,task) -> {
            if (task.getVersion() != newTask.getVersion()) {
                return task;
            }
            newTask.increaseVersion();
            return newTask;
        });
        if (task1 != newTask ) {
            throw new OptimisticException();
        }
        if (task1 == null) {
            return false;
        } else {
            return true;
        }
    };

    public boolean delete(Integer taskId) {
        if (localCache.containsKey(taskId)) {
            localCache.remove(taskId);
            return true;
        }
        return false;
    }

}
