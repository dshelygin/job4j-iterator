package iterators;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by dshelygin on 15.04.2018.
 */
public class MatrixIteratorTest {
    @Test
    public void hasNext() throws Exception {
        MatrixIterator it = new MatrixIterator(new int[][] {{1},{3,4,5}});
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void next() throws Exception {
        MatrixIterator it = new MatrixIterator(new int[][] {{1},{3,4,5}});
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
    }


}