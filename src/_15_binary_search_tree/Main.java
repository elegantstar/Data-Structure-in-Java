package _15_binary_search_tree;

public class Main {
    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(5);
        binarySearchTree.add(2);
        binarySearchTree.add(9);
        binarySearchTree.add(3);
        binarySearchTree.add(7);
        binarySearchTree.add(4);
        binarySearchTree.add(8);
        binarySearchTree.add(1);
        binarySearchTree.add(6);
        binarySearchTree.printTree();
        System.out.println("traversal");
        binarySearchTree.traversal();

        binarySearchTree.remove(9);
        binarySearchTree.printTree();

    }
}
