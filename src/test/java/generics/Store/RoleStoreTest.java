package generics.Store;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dshelygin on 16.04.2018.
 */
public class RoleStoreTest {
    private RoleStore roleStore = new RoleStore();

    @Test
    public void testRoleStore() {
        roleStore.add(new Role("tester1"));
        roleStore.add(new Role("tester2"));
        roleStore.add(new Role("tester3"));
        assertTrue(roleStore.replace("tester2", new Role("new_Tester")));
        assertTrue(roleStore.delete("tester3"));
        assertNull(roleStore.findById("tester3"));
        assertNull(roleStore.findById("tester2"));
        assertNotNull(roleStore.findById("new_Tester"));

    }
}