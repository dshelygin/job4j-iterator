package generics.Store;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dshelygin on 16.04.2018.
 */
public class UserStoreTest {
    private UserStore userStore = new UserStore();

    @Test
    public void testUserStore() {
        userStore.add(new User("tester1"));
        userStore.add(new User("tester2"));
        userStore.add(new User("tester3"));
        assertTrue(userStore.replace("tester2", new User("new_Tester")));
        assertTrue(userStore.delete("tester3"));
        assertNull(userStore.findById("tester3"));
        assertNull(userStore.findById("tester2"));
        assertNotNull(userStore.findById("tester1"));

    }


}