package mThreading.threads;

import mThreading.threads.User;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private HashMap<Integer,User> storage = new HashMap<>();

    public synchronized boolean add (User user) {
        if (!storage.containsKey(user.getId())) {
            storage.put(user.getId(), user);
            return true;
        }
        return false;
    }

    public synchronized boolean update(User user){
        if (storage.containsKey(user.getId())) {
            storage.put(user.getId(),user);
            return true;
        }
        return false;
    }

    public synchronized boolean delete(User user) {
        if (storage.containsKey(user.getId())) {
            storage.remove(user.getId());
            return true;
        }
        return false;
    }

    public synchronized  void transfer(int fromId, int toId, int amount) {
        if (storage.containsKey(fromId) && storage.containsKey(toId)) {
            storage.get(fromId).descreaseAmount(amount);
            storage.get(toId).increaseAmount(amount);
        }
    }

    public synchronized void putMoney(int id, int amount) {
        if (storage.containsKey(id)) {
            storage.get(id).increaseAmount(amount);
        }
    }

    public synchronized int getAmount(int userId) {
        if (storage.containsKey(userId)) {
            return storage.get(userId).getAmount();
        }
        return 0;
    }
}
