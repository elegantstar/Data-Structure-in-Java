package _16_avl_tree;

public class Main {
    public static void main(String[] args) {

        AVLTree avlTree = new AVLTree();
        avlTree.add(5);
        avlTree.add(2);
        avlTree.add(9);
        avlTree.add(3);
        avlTree.add(7);
        avlTree.add(4);
        avlTree.add(8);
        avlTree.add(1);
        avlTree.add(6);
        avlTree.printTree();
        System.out.println("traversal");
        avlTree.traversal();

        avlTree.remove(9);
        avlTree.printTree();
        
    }
}
