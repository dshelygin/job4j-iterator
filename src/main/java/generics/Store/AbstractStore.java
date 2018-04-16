package generics.Store;

import generics.SimpleArray;

import java.util.Iterator;

/**
 * Created by dshelygin on 16.04.2018.
 */
public abstract class  AbstractStore<T extends Base>  {
    private SimpleArray<T> values = new  SimpleArray<T>();

    public void add(T model) {
        values.add(model);
    }

    public boolean replace(String id, T model) {
        if (delete(id)) {
            add(model);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String id) {
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            T tmp = it.next();
            if (tmp.getId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public T findById(String id) {
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            T tmp = it.next();
            if (tmp.getId().equals(id)) { return tmp; }
        }
        return null;
    }

}
