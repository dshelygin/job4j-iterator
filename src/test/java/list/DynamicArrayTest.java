package list;


import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Created by dshelygin on 19.04.2018.
 */
public class DynamicArrayTest {
    private DynamicArray<String> tArray;

    @Before
    public void setUp() {
        tArray =  new DynamicArray<String>();
    }

    @Test
    public void CheckArray() {
        tArray.add("Hello");
        tArray.add("World");
        tArray.add("Hello");
        tArray.add("HelloPeople");
        assertThat(tArray.get(0), is("Hello"));
        Iterator<String> it = tArray.iterator();
        assertThat(it.hasNext(),is(true));
        assertThat(it.next(),is("Hello"));
        assertThat(it.next(),is("World"));
        assertThat(it.next(),is("Hello"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shouldReturnEvenNumbersSequentially () {
        Iterator<String> it = tArray.iterator();
        tArray.add("Spoil this");
        it.next();
    }

}