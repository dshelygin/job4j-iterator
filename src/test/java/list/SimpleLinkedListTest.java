package list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.is;

/**
 * Created by dshelygin on 19.04.2018.
 */
public class SimpleLinkedListTest {
    private SimpleLinkedList<String> tList;

    @Before
    public void setUp() {
        tList =  new SimpleLinkedList<String>();
    }

    @Test
    public void testList(){
        tList.add("Hello");
        tList.add("World");
        tList.add("Hi");
        tList.add("People");
        Iterator<String> it = tList.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(),is("Hello"));
        assertThat(it.next(),is("World"));
        assertThat(it.next(),is("Hi"));
        assertThat(it.next(),is("People"));
        assertThat(tList.get(1),is("World"));
    }

}