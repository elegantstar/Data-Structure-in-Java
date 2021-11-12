package _14_binary_tree_BFS;

public class Main {
    public static void main(String[] args) {

        // TODO : 위에서부터 아래로, 좌측에서 부터 우측으로 데이터를 삽입하는 트리
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

        // TODO : 레벨 순회
        System.out.println("레벨 순회");
        normalTree.levelOrder();
    }
}
