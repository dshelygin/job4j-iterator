package list;

import com.sun.istack.internal.Nullable;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by dshelygin on 19.04.2018.
 */
@ThreadSafe
public class SimpleLinkedList<T>  implements Iterable<T>{
    @GuardedBy("this")
    private Node<T> head = null;
    @GuardedBy("this")
    private Node<T> tail = null;
    @GuardedBy("this")
    private int modCounter = 0;
    @GuardedBy("this")
    private int size = 0;

    public static class Node<T> {
        private Node previous;
        private Node next;
        private T value;
        private int index ;

        public Node(T value, Node previous, Node next, int index) {
            this.previous = previous;
            this.next = next;
            this.value = value;
            this.index = index;
        }

        public Node getPrevious() {
            return previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public T getValue(){
            return value;
        }

        public int getIndex(){
            return index;
        }

   }

   @Nullable
   public synchronized int getSize(){
        return size;
   }

   @Nullable
   public synchronized  Node getHead() {
        return head;
   }

   synchronized void  setHead(Node head) {
        this.head = head;
   }

   @Nullable
   public synchronized Node getTail(){
        return tail;
   }

   synchronized void setTail(Node tail) {
       this.tail = tail;
   }

    @Nullable
    public synchronized T get(int index){
            Node tempNode = head;
            while (tempNode != null) {
                if (tempNode.getIndex() == index ) {
                    return (T) tempNode.getValue();
                }
                tempNode = tempNode.getNext();
            }
            return null;
    }

    //добавляем в конец
    public synchronized void add(T value) {
        modCounter++;
        Node tempNode = new Node(value,tail,null,size++);
        if (tail != null) {
            tail.setNext(tempNode);
        }
        tail = tempNode;
        if (head == null) {
            head = tempNode;
        }
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            private int expectedModCount = modCounter;

            public boolean hasNext() {
                return current != null ;
            }
            @Nullable
            public T next() throws NoSuchElementException,ConcurrentModificationException {
                if (expectedModCount != modCounter) {
                    throw new ConcurrentModificationException();
                }
                if (hasNext()) {
                    Node tempNode = current;
                    current = current.getNext();
                    return (T) tempNode.getValue();
                } else {
                    throw new NoSuchElementException();
                }
            }

            public void remove()   {
                if (current != null) {
                     if (current.getPrevious().getPrevious() != null) {
                            current.getPrevious().getPrevious().setNext(current);
                            current.setPrevious(current.getPrevious().getPrevious());
                     } else {
                         current.setPrevious(null);
                         setHead(current);
                     }

                } else {
                    Node newTail = getTail().getPrevious();
                    if (newTail != null) {
                        newTail.setNext(null);
                        setTail(newTail);
                    } else {
                        setHead(null);
                        setTail(null);
                    }

                }
            }


        };
    }
}
