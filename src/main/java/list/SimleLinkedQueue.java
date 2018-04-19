package list;

/**
 * Created by dshelygin on 19.04.2018.
 */
public class SimleLinkedQueue<T> extends SimpleLinkedList<T> {
    public void push(T value) {
        add(value);
    }

    public T poll () {
        Node tempNode = getHead();
        setHead(tempNode.getNext());
        if (tempNode.getNext() != null ) {
            tempNode.getNext().setPrevious(null);
        };
        return (T) tempNode.getValue();
    }
}
