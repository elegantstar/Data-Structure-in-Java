package _19_b_tree;

public class Main {
    public static void main(String[] args) {

        BTree bTree = new BTree(2);
        bTree.add(3);
        bTree.add(4);
        bTree.add(5);
        bTree.add(1);
        bTree.add(2);
        bTree.add(6);
        bTree.add(8);
        bTree.add(9);
        bTree.add(7);
        bTree.add(10);
        bTree.add(12);
        bTree.add(13);
        bTree.add(11);
        bTree.add(14);
        bTree.add(15);

        bTree.printTree();
        bTree.traversal();

    }
}
