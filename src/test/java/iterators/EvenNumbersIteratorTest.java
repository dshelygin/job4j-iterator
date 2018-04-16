package iterators;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by dshelygin on 15.04.2018.
 */
public class EvenNumbersIteratorTest {
    @Test
    public void hasNext() throws Exception {
        EvenNumbersIterator it = new EvenNumbersIterator(new int[] {1,4,7,8,6,3,5});
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void next() throws Exception {
        EvenNumbersIterator it = new EvenNumbersIterator(new int[] {1,4,7,8,6,3,5});
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(6));
    }

}