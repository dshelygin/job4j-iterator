package list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Created by dshelygin on 19.04.2018.
 */
public class SimleLinkedQueueTest {
    private SimleLinkedQueue<String> tList;

    @Before
    public void setUp() {
        tList =  new SimleLinkedQueue<String>();
    }

    @Test
    public void testList(){
        tList.push("Hello");
        tList.push("World");
        tList.push("Hi");
        tList.push("People");
        assertThat(tList.poll(),is("Hello"));
        assertThat(tList.poll(),is("World"));
        assertThat(tList.poll(),is("Hi"));
        assertThat(tList.poll(),is("People"));
    }

}