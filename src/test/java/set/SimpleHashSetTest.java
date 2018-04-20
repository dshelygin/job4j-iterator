package set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by dshelygin on 20.04.2018.
 */
public class SimpleHashSetTest {
    private SimpleHashSet<String> tList;

    @Before
    public void setUp() {
        tList =  new SimpleHashSet<String>();
    }

    @Test
    public void testList(){
        assertTrue(tList.add("Hello"));
        assertFalse(tList.add("Hello"));
        assertTrue(tList.add("World"));
        assertTrue(tList.add("Hi"));
        assertTrue(tList.add("People"));
        assertTrue(tList.contains("Hi"));
        assertFalse(tList.contains("Man"));
        assertTrue(tList.remove("World"));
        assertFalse(tList.remove("World"));
    }


}