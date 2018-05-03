package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class BinaryTree<E extends Comparable<E>>  {
    private BinaryNode<E> root;

    public BinaryTree(E rootValue) {
        this.root = new BinaryNode<>(rootValue);
    }

    public boolean add(E value) {
        Optional<BinaryNode<E>> closestNode = findClosestNode(value);
        if (closestNode.isPresent()) {
            if (closestNode.get().eqValue(value)) {
                return false;
            }
            if (closestNode.get().smallerValueThan(value)) {
                closestNode.get().addBiggerChildren(value);
                return true;
            } else {
                closestNode.get().addSmallerChildren(value);
                return true;
            }
        }
        return false;
    }

    public Optional<BinaryNode<E>> findBy(E value) {
        Optional<BinaryNode<E>> closestNode = findClosestNode(value);
        if (closestNode.isPresent()) {
            if (closestNode.get().eqValue(value)) {
                return closestNode;
            }
        }
        return Optional.empty();
    }

    private  Optional<BinaryNode<E>> findClosestNode(E value) {
        BinaryNode<E> currentNode = root;
        Optional<BinaryNode<E>> result = Optional.empty();
        do {
            if (currentNode!= null) {
                if (currentNode.eqValue(value)) {
                    return Optional.of(currentNode);
                }
                if ((currentNode).smallerValueThan(value)) {
                    if (currentNode.getBiggerChildren() == null) {
                        return Optional.of(currentNode);
                    }
                    currentNode = currentNode.getBiggerChildren();
                } else {
                    if (currentNode.getSmallerChildren() == null) {
                        return Optional.of(currentNode);
                    }
                    currentNode = currentNode.getSmallerChildren();
                }

            } else {
                return Optional.empty();
            }
        } while (currentNode.hasChildren());

        return Optional.of(currentNode);

    }

    public Iterator<E> iterator() {
        return new BinaryTreeIterator<E>(root);
    }

    private class BinaryTreeIterator<E extends Comparable<E>> implements Iterator<E> {
        private Queue<BinaryNode<E>> data = new LinkedList<>();
        private BinaryNode<E> el;

        @Override
        public boolean hasNext() {
            return !data.isEmpty();

        }

        @Override
        public E next() {
            if (hasNext()) {
                el = data.poll();
                if (el.getSmallerChildren() != null) {
                    data.offer(el.getSmallerChildren());
                }
                if (el.getBiggerChildren() != null) {
                    data.offer(el.getBiggerChildren());
                }
                return el.getValue();
            }
            return null;
        }

        /**.
         * test
         * @param root test
         */
        public BinaryTreeIterator(BinaryNode<E> root) {
            data.offer(root);
        }
    }


}
