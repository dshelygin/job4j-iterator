package mThreading.threads;

public class User {
    private final int id;
    private int amount;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void increaseAmount(int increse) {
        this.amount += increse;
    }

    public void descreaseAmount(int decrease) {
        this.amount -= decrease;
    }
}
