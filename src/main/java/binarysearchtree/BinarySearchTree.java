package binarysearchtree;

// Binary Search Tree class
public class BinarySearchTree {

    /** An inner class representing a node in a BST tree */
    private class BSTNode {
        int data; // value at the node
        BSTNode left; // left child
        BSTNode right; // right child

        BSTNode(int newdata) {
            data = newdata;
        }
    } // end of class BSTNode

    private BSTNode root; // the root of the tree

    /**
     * Constructor
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert an element in the BST (iterative)
     * @param elem value to insert
     */
    public void insert(int elem) {
        BSTNode prev = null; // need to keep track of the node to which we will be attaching the new node
        BSTNode current = root;
        if (root == null) {
            root = new BSTNode(elem);
            return;
        }
        while (current != null) {
            if (elem >= current.data) {
                prev = current;
                current = current.right;
            }
            else {
                prev = current;
                current = current.left;
            }
        }
        if (elem < prev.data) {
            prev.left = new BSTNode(elem);
        }
        else {
            prev.right = new BSTNode(elem);
        }
    }

    /**
     * Return a number of nodes whose values are in the range from low to high (inclusive).
     * @param low
     * @param high
     * @return a number of nodes with values in the range [low, high], inclusive.
     * Calls the private recursive method numInRange
     */
    public int numInRange(int low, int high) {
        return numInRange(low, high, root);
    }


    /**
     * A private recursive method that returns a number of nodes whose values
     * are in the range from low to high (inclusive).
     * @param low
     * @param high
     * @return a number of nodes with values in the range [low, high], inclusive.
     */
    private int numInRange(int low, int high, BSTNode root) {
        if (root == null)
            return 0;
        if (root.data >= low && root.data <= high) {
            return 1 + numInRange(low, high, root.left) + numInRange(low, high, root.right);
        }
        else if (root.data < low)
            return numInRange(low, high, root.right);
        else if (root.data > high)
            return numInRange(low, high, root.left);
        return 0;
    }

}

