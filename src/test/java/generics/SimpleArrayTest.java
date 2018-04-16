package generics;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Created by dshelygin on 16.04.2018.
 */
public class SimpleArrayTest {

    private SimpleArray<Integer> tArray;

    @Before
    public void setUp() {
        tArray = new SimpleArray<Integer>();
    }

    @Test
    public void CheckArray() {
        tArray.add(1);
        tArray.add(2);
        tArray.add(3);
        assertThat(tArray.get(0), is(1));
        Iterator<Integer> it = tArray.iterator();
        assertThat(it.hasNext(),is(true));
        assertThat(it.next(),is(1));
        assertThat(it.next(),is(2));
        assertThat(it.next(),is(3));
        assertThat(it.hasNext(),is(false));
    }

}