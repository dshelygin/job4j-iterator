package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dshelygin on 16.04.2018.
 */
public class Converter {
    Iterator<Integer> convert(final Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> curIterator ;
            private int curIteratorPointer = 0;

            {
                if (it.hasNext()) {
                    curIterator = it.next();
                }
            }
            @Override
            public boolean hasNext() {
                if (curIterator.hasNext()) {
                    return true;
                } else {
                    while (it.hasNext()) {
                        curIterator = it.next();
                        if (curIterator.hasNext()) {
                            return true;
                        }
                    }
                }
                return false;
            }
            @Override
            public Integer next() {
                if (hasNext()) {
                    return curIterator.next();
                } else {
                    throw new NoSuchElementException();
                }
            }
            @Override
            public void remove() throws UnsupportedOperationException  {
                throw new UnsupportedOperationException("remove");
            }


        };
    }
}
