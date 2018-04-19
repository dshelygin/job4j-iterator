package list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dshelygin on 19.04.2018.
 */
public class DynamicArray<T> implements Iterable<T> {
    private Object[] values = new Object[DEFAULLT_SIZE];
    private static final int DEFAULLT_SIZE = 2;
    private static final int INCREASE_SIZE = 10;
    private int size = 0;
    private int modCounter = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pointer = 0;
            private int expectedModCount = modCounter;

            public boolean hasNext() {
                return pointer < size;
            }
            public T next() throws NoSuchElementException,ConcurrentModificationException {
                if (expectedModCount != modCounter) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    return (T) values[pointer++];
                } else {
                    throw new NoSuchElementException();
                }
            }

            public void remove() throws UnsupportedOperationException  {
                throw new UnsupportedOperationException();
            }
        };
    }

    public void add(T value) {
        modCounter++;
        if ( size >= values.length) { grow(INCREASE_SIZE); }
        values[size++] = value;
    }

    public T get(int index) {
        return (T) values[index];
    }

    private void grow(int minCapacity) {
        int oldCapacity = values.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        values = Arrays.copyOf(values, newCapacity);
    }
}
