package _13_binary_tree_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class NormalTree {

    Node root;

    public void addData(int key) {
        // TODO : 새로운 노드를 생성하고, 해당 노드의 key 값을 할당한다.
        Node newNode = new Node();
        newNode.key = key;

        // TODO : 최초의 노드를 생성하는 경우(root가 null)는 생성한 노드를 root로 만든다.
        if (root == null) {
            root = newNode;
        } else {
            // TODO : 트리를 만들기 위한 큐를 생성한다.
            Queue<Node> queue = new LinkedList<>();
            // TODO : 큐에 root 노드를 삽입한다.
            queue.offer(root);

            while (!queue.isEmpty()) {
                // TODO : 큐에서 노드를 하나 꺼내서 부모 노드로 만든다.
                Node parentNode = queue.poll();
                if (parentNode.left != null) {
                    // TODO : 큐에서 꺼낸 노드(부모 노드)의 좌측 노드가 존재하면, 해당 노드를 큐에 삽입한다.
                    queue.offer(parentNode.left);
                } else {
                    // TODO : 큐에서 꺼낸 노드(부모 노드)의 좌측 노드가 존재하지 않으면 , 새로 생성했던 newNode를 부모 노드의 좌측 노드로 연결한다.
                    parentNode.left = newNode;
                    break;
                }
                if (parentNode.right != null) {
                    // TODO : 큐에서 꺼낸 노드(부모 노드)의 우측 노드가 존재하면, 해당 노드를 큐에 삽입한다.
                    queue.offer(parentNode.right);
                } else {
                    // TODO : 큐에서 꺼낸 노드(부모 노드)의 우측 노드가 존재하지 않으면, 새로 생성했던 newNode를 부모 노드의 우측 노드로 연결한다.
                    parentNode.right = newNode;
                    break;
                }
            }
        }
    }

    public void preOrderTraversal() {
        // TODO : 전위 순회
        preOrder(root);
        System.out.println("");
    }

    public void inOrderTraversal() {
        // TODO : 중위 순회
        inOrder(root);
        System.out.println("");
    }

    public void postOrderTraversal() {
        // TODO : 후위 순회
        postOrder(root);
        System.out.println("");
    }

    private void preOrder(Node node) {
        // TODO : 전위 순회
        if (node == null) {
            return;
        }
        visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 일반적인 사칙 연산이 중위 순회의 구조와 같다. -> (2 + 3) * (3 * 5) 연산자가 부모 노드에 위치.
    private void inOrder(Node node) {
        // TODO : 중위 순회
        if (node == null) {
            return;
        }
        inOrder(node.left);
        visit(node);
        inOrder(node.right);
    }

    // 컴퓨터가 연산을 처리할 때 후위 순회 방식을 사용한다.
    // (2 + 3) * (3 * 5)인 경우 -> 2, 3, +, 3, 5, *, *
    // stack에 값을 저장하고 연산자가 나오면 꺼내서 연산하고, 연산된 결과를 stack에 저장하는 방식으로 반복하여 최종 결과를 계산한다.
    private void postOrder(Node node) {
        // TODO : 후위 순회
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        visit(node);
    }

    private void visit(Node node) {
        System.out.printf("%d ", node.key);
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
