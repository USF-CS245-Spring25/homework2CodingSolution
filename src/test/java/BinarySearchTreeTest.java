import binarysearchtree.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    void testNumInRange() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(1);
        tree.insert(10);
        tree.insert(8);
        tree.insert(12);
        tree.insert(16);
        tree.insert(15);
        tree.insert(25);
        tree.insert(11);

        assertEquals(4, tree.numInRange(11, 16)); // {11, 12, 15, 16}
        assertEquals(4, tree.numInRange(8, 12)); // {8, 10, 11, 12}
        assertEquals(2, tree.numInRange(1, 6)); // {1, 6}
        assertEquals(0, tree.numInRange(30, 40)); // No elements in range
        assertEquals(9, tree.numInRange(1, 25)); // All elements in range
    }

    @Test
    void testEmptyTree() {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals(0, tree.numInRange(1, 10));
    }

    @Test
    void testNumInRangeOnlyRoot() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        assertEquals(1, tree.numInRange(5, 5));
        assertEquals(0, tree.numInRange(6, 10));
        assertEquals(0, tree.numInRange(1, 4));
    }

    @Test
    void testNumInLargeRange() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);
        tree.insert(101);

        assertEquals(8, tree.numInRange(Integer.MIN_VALUE, Integer.MAX_VALUE)); // all node values are in this range
    }

}