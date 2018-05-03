package tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    private BinaryTree<Integer> values = new BinaryTree<>(10);

    @Test
    public void theSameElementSholdNotBeAdded() {
        assertTrue(values.add(1));
        assertTrue(values.add(20));
        assertTrue(values.add(5));
        assertTrue(values.add(15));
        assertTrue(values.add(16));
        assertTrue(values.add(6));
        assertFalse(values.add(6));
    }





}