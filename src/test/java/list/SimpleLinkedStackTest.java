package list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by dshelygin on 19.04.2018.
 */
public class SimpleLinkedStackTest {
    private SimpleLinkedStack<String> tList;

    @Before
    public void setUp() {
        tList =  new SimpleLinkedStack<String>();
    }

    @Test
    public void testList(){
        tList.push("Hello");
        tList.push("World");
        tList.push("Hi");
        tList.push("People");
        assertThat(tList.poll(),is("People"));
        assertThat(tList.poll(),is("Hi"));
        assertThat(tList.poll(),is("World"));
        assertThat(tList.poll(),is("Hello"));
    }

}