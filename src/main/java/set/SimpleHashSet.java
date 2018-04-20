package set;

import list.SimpleLinkedList;

import java.util.Iterator;

import static java.lang.Math.abs;

/**
 * Created by dshelygin on 20.04.2018.
 */
public class SimpleHashSet<T> {
    private SimpleLinkedSet<T>[] values;

    public SimpleHashSet() {
        this.values = new SimpleLinkedSet[99999999];
    }

    public Boolean add(T value) {
        int hash = returnHash(value);
        if (values[hash] == null ) {
            values[hash] = new SimpleLinkedSet<T>();
        }
        return values[hash].add(value);
    }

    public Boolean contains(T value) {
        int hash = returnHash(value);
        if (values[hash] == null ) {
            return false;
        } else {
            Iterator<T> it = values[hash].iterator();
            while (it.hasNext()){
                if (it.next().equals(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    public Boolean remove (T value){
        int hash = returnHash(value);
        if (values[hash] == null ) {
            return false;
        } else {
            Iterator<T> it = values[hash].iterator();
            while (it.hasNext()){
                if (it.next().equals(value)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    private int returnHash(T value) {
        return Math.round(abs(value.hashCode())/10000);
    }


}
