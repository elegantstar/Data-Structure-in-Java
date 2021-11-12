package _12_normal_binary_tree;

public class Main {
    public static void main(String[] args) {

        NormalTree normalTree = new NormalTree();
        normalTree.add(1);
        normalTree.add(2);
        normalTree.add(3);
        normalTree.add(4);
        normalTree.add(5);
        normalTree.add(6);
        normalTree.add(7);
        normalTree.add(8);
        normalTree.add(9);
        normalTree.add(10);
        normalTree.add(11);
        normalTree.add(12);
        normalTree.printTree();
        System.out.println("traversal");
        normalTree.levelOrder();

    }
}
