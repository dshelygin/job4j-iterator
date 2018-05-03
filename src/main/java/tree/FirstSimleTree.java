package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**.
 * test class
 * @param <E>
 */
public class FirstSimleTree<E extends Comparable<E>> implements SimpleTree<E> {
    /**.
     *  list of array
     */
    private Node<E> root;

    public FirstSimleTree(E rootValue) {
        this.root = new Node<>(rootValue);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(child).isPresent()) {
            return false;
        }
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isPresent()) {
            parentNode.get().add(new Node<>(child));
            return true;
        }
        return false;

    }

    /**.
     * test
     * @param value test
     * @return test
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**.
     * test
     * @return test
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleTreeIterator<>(root);
    }

    private class SimpleTreeIterator<E extends Comparable<E>> implements Iterator<E> {
        private Queue<Node<E>> data = new LinkedList<>();
        private Node<E> el;

        @Override
        public boolean hasNext() {
            return !data.isEmpty();

        }

        @Override
        public E next() {
            if (hasNext()) {
                el = data.poll();
                for (Node<E> child : el.leaves()) {
                    data.offer(child);
                }
                return el.getValue();
            }
            return null;
        }

        /**.
         * test
         * @param root test
         */
        public SimpleTreeIterator(Node<E> root) {
            data.offer(root);
        }
    }

    public boolean isBinary() {
        Boolean result = false;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                result = false;
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;

    }
}
