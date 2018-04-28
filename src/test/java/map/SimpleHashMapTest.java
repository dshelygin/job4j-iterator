package map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SimpleHashMap
 */
public class SimpleHashMapTest {
    private SimpleHashMap<String,String > testMap = new SimpleHashMap<>();
    private String testKey1 = "testkey";
    private String testKey2 = "testkey2";

    @Before
    public void initializaion() {

        testMap.insert("User1", "Hello user1");
        testMap.insert(testKey1,"Hello testKey");
        testMap.insert(testKey2,"Hello testkety2");
        testMap.insert("User2", "Hello user2");
    }

    @Test
    public void test1(){
        assertTrue(testMap.insert("User3", "Hello User3"));
        assertFalse(testMap.insert(testKey1, "Hello another testKey"));
        assertTrue(testMap.delete(testKey1));
        assertEquals(testMap.get(testKey2),"Hello testkety2");
    }

}