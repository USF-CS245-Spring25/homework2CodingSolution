package binarysearchtree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
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
        System.out.println(tree.numInRange(11, 17));
    }
}
