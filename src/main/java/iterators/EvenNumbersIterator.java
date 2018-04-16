package iterators;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dshelygin on 15.04.2018.
 */
public class EvenNumbersIterator implements Iterator {
    private final int[] values;
    private int x = 0;

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
        if (!isEven(values[x])) {
            x = getNextPosition();
        }
    }
    @Override
    public boolean hasNext() {
        if (x >= 0) {
            return (values.length > x) && isEven(values[x]);
        } else {
            return false;
        }
    }
    private int getNextPosition(){
        for (int i=x; i < values.length; i++) {
              if (isEven(values[i])) {
                  return i;
              }

        }
        return -1;
    }
    private Boolean isEven(int value) {
        return (value & 1) == 0;
    }
    @Override
    public Integer next() throws NoSuchElementException {
        if (hasNext()) {
            int value = values[x++];
            x = getNextPosition();
            return value;
        } else {
            throw new NoSuchElementException();
        }
    }
    @Override
    public void remove() throws UnsupportedOperationException  {
        throw new UnsupportedOperationException("remove");
    }
}
