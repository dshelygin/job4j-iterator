package generics;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dshelygin on 16.04.2018.
 */
public class SimpleArray<T> implements Iterable<T> {
    private static final int DEFAULLT_SIZE = 10;
    private static final int INCREASE_SIZE = 10;
    private int size = 0;

    private Object[] values = new Object[DEFAULLT_SIZE];

    public void add(T model){
        if ( size >= values.length) { grow(INCREASE_SIZE); }
        values[size++] = model;
    };

    public void set(int index, T model){
        values[index] = model;
    }

    public void  delete(int index) {
        values[index] = null;
    }

    public T get(int index) {
        return (T) values[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pointer = 0;

            public boolean hasNext() {
                return pointer < size;
            }
            public T next() throws NoSuchElementException{
                    if (hasNext()) {
                        return (T) values[pointer++];
                    } else {
                        throw new NoSuchElementException();
                    }
                }

            public void remove() throws UnsupportedOperationException  {
                int numMoved = size - pointer  ;
                if (numMoved > 0)
                    System.arraycopy(values, pointer, values, pointer -1,
                            numMoved);
                values[--size] = null; // clear to let GC do its work
           }
        };

    }
    private void grow(int minCapacity) {
        int oldCapacity = values.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
         values = Arrays.copyOf(values, newCapacity);
    }
}
