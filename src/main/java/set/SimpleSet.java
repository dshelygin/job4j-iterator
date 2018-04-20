package set;

import generics.SimpleArray;
import list.DynamicArray;

import java.util.Iterator;

/**
 * Created by dshelygin on 20.04.2018.
 */
public class SimpleSet<T> implements Iterable<T>{

    private DynamicArray<T> values = new DynamicArray<T>();

    @Override
    public Iterator<T> iterator() {
        return values.iterator();
    }

    public void add(T value) {
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            if (it.next().equals(value)) {
                return;
            };
        }
        values.add(value);
    }
}
