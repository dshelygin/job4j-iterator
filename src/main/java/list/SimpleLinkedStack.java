package list;

/**
 * Created by dshelygin on 19.04.2018.
 */
public class SimpleLinkedStack<T> extends SimpleLinkedList<T>{
    public void push(T value) {
        add(value);
    }

    public T poll () {
        Node tempNode = getTail();
        setTail(tempNode.getPrevious());
        if (tempNode.getPrevious() != null ) {
            tempNode.getPrevious().setNext(null);
        };
        return (T) tempNode.getValue();
    }
}
