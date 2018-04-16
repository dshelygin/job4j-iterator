package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dshelygin on 16.04.2018.
 */
public class PrimeIterator  implements Iterator {
    private final int[] values;
    private int x = 0;

    public PrimeIterator(final int[] values) {
        this.values = values;
        if (!isPrime(values[x])) {
            x = getNextPosition();
        }
    }
    public boolean hasNext() {
        if (x >= 0) {
            return (values.length > x) && isPrime(values[x]);
        } else {
            return false;
        }
    }
    private int getNextPosition(){
        for (int i=x; i < values.length; i++) {
            if (isPrime(values[i])) {
                return i;
            }
        }
        return -1;
    }
    public Integer next() throws NoSuchElementException {
        if (hasNext()) {
            int value = values[x++];
            x = getNextPosition();
            return value;
        } else {
            throw new NoSuchElementException();
        }
    }
    public void remove() throws UnsupportedOperationException  {
        throw new UnsupportedOperationException("remove");
    }
    public Boolean isPrime(int digit) {
        if (digit == 1) {
            return false;
        }
        for(int i=2; i*i<=digit; i++ ) {
            if(digit%i==0) {
                return false;
            }
        }
        return true;
    }
}