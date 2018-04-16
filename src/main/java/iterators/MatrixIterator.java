package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dshelygin on 15.04.2018.
 */
public class MatrixIterator implements Iterator {
    private final int[][] values;
    private int x = 0;
    private int y = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }
    public boolean hasNext() {
        return (values.length > x) && (values[x].length > y);
    }
    private int[]  getNextPosition(){
        int resultX;
        int resultY;
        if (y >= values[x].length - 1 ) {
            resultY = 0;
            resultX = x + 1;
        } else {
            resultY = y + 1;
            resultX = x;
        }
        return new int[] {resultX, resultY};
    }
    public Integer next() throws NoSuchElementException {
        if (hasNext()) {
            int value = values[x][y];
            int[] nextPosition = getNextPosition();
            x = nextPosition[0];
            y = nextPosition[1];
            return value;
        } else {
            throw new NoSuchElementException();
        }
    }
    public void remove() throws UnsupportedOperationException  {
        throw new UnsupportedOperationException("remove");
    }
}
