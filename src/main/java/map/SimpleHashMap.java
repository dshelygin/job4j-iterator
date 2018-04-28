package map;

import java.util.Iterator;

/**
 * simplehashmap
 */
public class SimpleHashMap<K,V> implements Iterable<K> {
    private final static int DEFAULT_SIZE = 1000;
    private final static int INCREASE_SIZE = 10;
    private Object[] values = new Object[DEFAULT_SIZE];
    private int size = 0;

    private class Entity<K,V> {
        private final K key;
        private final V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int pointer = 0;

            @Override
            public boolean hasNext() {
                return findNextIndex() != null;
            }

            @Override
            public K next() {
            	if (hasNext()) {
            		int lastPointer = pointer;
                    pointer = findNextIndex();
                    Entity<K,V> tmpEntity =  (Entity<K,V>) values[lastPointer];
                    return tmpEntity.getKey();
                } else {
                    return null;
                }
            }

            private Integer findNextIndex() {
                for (int i = pointer; pointer < size; i++) {
                    if (values[i] != null) {
                        return i;
                    }
                }
                return null;
            }
        };
   }

    public boolean insert(K key, V value) {
        if (size >= values.length) {
            grow();
        }
        int index = getIndex(key, values.length);
        if (values[index] != null) {
            return false;
        } else {
            values[index] = new Entity(key,value);
            size++;
            return true;
        }
    };

    public V get(K key) {
        Entity<K,V> tmpEntity =  (Entity<K,V>)values[getIndex(key,values.length)];
        if (tmpEntity != null) {
            if (key == tmpEntity.getKey()) {
                return tmpEntity.getValue();
            }
        }
        return null;

    }

    public Boolean delete(K key) {
        int index = getIndex(key, values.length);
        Entity<K,V> tmpEntity = (Entity<K,V>)values[index];
        if (tmpEntity != null) {
            if (tmpEntity.getKey() == key) {
                values[index] = null;
                return true;
            }
        }
        return false;
    }

    private int getIndex(Object key, int size) {
        int hash = (key == null) ? 0 : (hash = key.hashCode()) ^ (hash >>> 16);
        return  (size - 1) & hash;
    }

    private void grow() {
        Object[] tmpValues = new Object[values.length + INCREASE_SIZE ];
        Iterator<K> it = iterator();
        int tmpIndex;
        K tmpKey;
        V tmpValue;
        while (it.hasNext()) {
            tmpKey  = it.next();
            tmpValue = get(tmpKey);
            tmpIndex = getIndex(tmpKey, tmpValues.length);
            tmpValues[tmpIndex] = new Entity<>(tmpKey,tmpValue);
        }
        values = tmpValues;
    }


}
