package _12_normal_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 트리 : 사이클이 존재하지 않는 연결 그래프
 * 이진 트리 : 자식 노드가 2개 이하인 트리
 */
public class NormalTree {

    private Node root;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node x = queue.poll();

                if (x.left != null) {
                    queue.offer(x.left);
                } else {
                    x.left = newNode;
                    break;
                }
                if (x.right != null) {
                    queue.offer(x.right);
                } else {
                    x.right = newNode;
                    break;
                }
            }
        }
    }

    public void levelOrder() {
        // TODO : 순회
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node parentNode = queue.poll();

            System.out.printf("%d ", parentNode.key);

            if (parentNode.left != null) {
                queue.offer(parentNode.left);
            }
            if (parentNode.right != null) {
                queue.offer(parentNode.right);
            }
            System.out.print("");
        }
    }

    private void printHelper(Node x, String indent, boolean last) {
        if (x != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            System.out.println(x.key);
            printHelper(x.left, indent, false);
            printHelper(x.right, indent, true);
        }
    }

    public void printTree() {
        printHelper(this.root, "", true);
    }
}
