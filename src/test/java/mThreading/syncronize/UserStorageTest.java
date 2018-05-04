package mThreading.syncronize;

import mThreading.threads.User;
import mThreading.threads.UserStorage;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStorageTest {
    private UserStorage userStoreage = new UserStorage();

    @Before
    public void initialization(){
        userStoreage.add(new User(1));
        userStoreage.add(new User(2));
        userStoreage.add(new User(3));

        userStoreage.putMoney(1,100);
        userStoreage.putMoney(2,100);
        userStoreage.putMoney(3,100);
         }

    @Test
    public void checkTransferProcessWithThreads() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k=0; k <50; k++) {
                    userStoreage.transfer(1,2,1);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k=0; k <40; k++) {
                    userStoreage.transfer(2,3,1);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k=0; k <30; k++) {
                    userStoreage.transfer(3,2,1);
                }
            }
        }).start();

        assertThat(userStoreage.getAmount(1),is(50));
        assertThat(userStoreage.getAmount(2),is(140));
        assertThat(userStoreage.getAmount(3),is(110));



    }


}