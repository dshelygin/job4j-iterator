package tree;

import com.sun.istack.internal.Nullable;

public class BinaryNode<E extends Comparable<E>>   {
    private E value;
    private BinaryNode<E> smallerChild;
    private BinaryNode<E> biggerChild;


    public BinaryNode(E value) {
        this.value = value;
    }

    boolean smallerValueThan(E that) {
        return this.value.compareTo(that) < 0;
    }

    boolean hasChildren() {
        boolean result = ((smallerChild == null) && (biggerChild == null));
        return !((smallerChild == null) && (biggerChild == null));
    }

    @Nullable
    BinaryNode<E> getSmallerChildren() {
        return smallerChild;
    }

    @Nullable
    BinaryNode<E> getBiggerChildren() {
        return biggerChild;
    };

    void addSmallerChildren(E value) {
        smallerChild = new BinaryNode<>(value);
    }

    void addBiggerChildren(E value) {
        biggerChild = new BinaryNode<>(value);
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    public E getValue() {
        return value;
    }

}
