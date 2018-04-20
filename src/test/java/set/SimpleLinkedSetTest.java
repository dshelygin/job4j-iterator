package set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by dshelygin on 20.04.2018.
 */
public class SimpleLinkedSetTest {
    private  SimpleLinkedSet<String> tList;

    @Before
    public void setUp() {
        tList =  new  SimpleLinkedSet<String>();
    }

    @Test
    public void testList(){
        tList.add("Hello");
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
    }

}