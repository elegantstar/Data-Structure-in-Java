package _14_binary_tree_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NormalTree {

    Node root;

    public void add(int key) {
        Queue<Node> queue = new LinkedList<>();

        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node parentNode = queue.poll();

                if (parentNode.left != null) {
                    queue.offer(parentNode.left);
                } else {
                    parentNode.left = newNode;
                    break;
                }
                if (parentNode.right != null) {
                    queue.offer(parentNode.right);
                } else {
                    parentNode.right = newNode;
                    break;
                }
            }
        }
    }

    private void visit(Node node) {
        System.out.printf("%d ", node.key);
    }

    public void levelOrder() {
        // TODO : 트리가 비어 있는 경우는 리턴
        if (root == null) {
            return;
        }
        // TODO : 트리의 깊이 우선 탐색에서는 스택 방식을 이용한 재귀적인 코드를 작성했으나
        // TODO : 레벨 순회는 큐를 이용하여 순회를 한다. 단순 이진트리에서는 데이터를 삽입한 순서대로 순회할 수 있다.
        Queue<Node> queue = new LinkedList<>();
        // TODO : 루트 노드를 큐에 삽입한다.
        queue.offer(root);

        while (!queue.isEmpty()) {
            // TODO : 큐에 삽입된 노드를 하나 꺼내서 방문한다.
            Node parentNode = queue.poll();

            visit(parentNode);

            // TODO : 방문한 노드의 좌측 자식 노드를 큐에 삽입한다.
            if (parentNode.left != null) {
                queue.offer(parentNode.left);
            }
            // TODO : 방문한 노드의 우측 자식 노드를 큐에 삽입한다.
            if (parentNode.right != null) {
                queue.offer(parentNode.right);
            }
        }
        System.out.println("");
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
