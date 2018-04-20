package set;

import list.SimpleLinkedList;

import java.util.Iterator;

/**
 * Created by dshelygin on 20.04.2018.
 */
public class SimpleLinkedSet<T> implements Iterable<T> {
    private SimpleLinkedList<T> values = new SimpleLinkedList<T>();

    @Override
    public Iterator<T> iterator() {
        return values.iterator();
    }

    public Boolean add(T value) {
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            if (it.next().equals(value)) {
                return false;
            };
        }
        values.add(value);
        return true;
    }
}
