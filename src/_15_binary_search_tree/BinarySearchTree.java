package _15_binary_search_tree;

/**
 * Binary Search Tree의 시간 복잡도
 * 검색 -> 평균: O(log n)   최악: O(n)
 * 삽입 -> 평균: O(log n)   최악: O(log n)
 * 삭제 -> 평균: O(log n)   최악: O(log n)
 */

public class BinarySearchTree {

    private Node root;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            root = insertNode(root, newNode);
        }
    }

    private Node insertNode(Node x, Node newNode) {
        /**
         * 1. x 노드가 null일 때까지 x 노드의 키와 새로운 노드의 키를 비교한다.
         * 1-1. x 노드의 키보다 작으면 좌측 노드로 이동한다.
         * 1-1-1. x 노드의 좌측 노드로 이동한다. (1로 이동)
         * 1-2. x 노드의 키보다 크면 우측 노드로 이동한다.
         * 1-2-1. x 노드의 우측 노드로 이동한다.
         * 2. x가 null이면 새로운 노드를 반환한다.
         */
        if (x == null) {
            return newNode;
        } else if (x.key > newNode.key) {
            x.left = insertNode(x.left, newNode);
        } else {
            x.right = insertNode(x.right, newNode);
        }
        return x;
    }

    public void remove(int key) {
        root = removeNode(root, key);
    }

    private Node removeNode(Node x, int key) {
        /**
         * 1. 삭제할 키를 찾는다.
         * 1-1. 삭제할 키가 없으면 예외 처리
         * 2. 삭제할 키를 찾았으면 삭제할 노드의 좌/우측 자식을 확인한다.
         * 2-1. 좌측 노드가 null이 아니다.
         * 2-1-1. 삭제할 노드의 좌측 서브 트리 중 가장 큰 키(predecessor key)를 가진 노드를 찾는다.
         * 2-1-2. 삭제할 키와 가장 큰 키를 swap한다.
         * 2-1-3. 삭제할 노드의 좌측 자식부터 다시 탐색 (1로 이동)
         * 2-2. 우측 노드가 null이 아니다.
         * 2-2-1. 삭제할 노드의 우측 서브 트리 중 가장 작은 키(successor key)를 가진 노드를 찾는다.
         * 2-2-2. 삭제할 키와 가장 작은 키를 swap한다.
         * 2-2-3. 삭제할 노드의 우측 자식부터 다시 탐색 (1로 이동)
         * 3. Leaf 노드이면 null을 반환하여 노드의 연결을 끊는다.
         */
        if (x == null) {
            throw new RuntimeException("노드를 찾을 수 없습니다.");
        } else if (x.key > key) {
            x.left = removeNode(x.left, key);
        } else if (x.key < key) {
            x.right = removeNode(x.right, key);
        } else {
            // TODO : 삭제할 키를 찾은 경우
            if (x.left != null) {
                // TODO : 삭제할 노드의 좌측 서브 트리 중 가장 큰 키를 가진 노드를 찾는다.
                Node predecessor = getLargestNode(x.left);
                // TODO : 삭제할 키와 좌측 서브 트리 노드 중 가장 큰 키와 Swap
                int removeKey = x.key;
                x.key = predecessor.key;
                predecessor.key = removeKey;
                // TODO : 삭제할 노드의 좌측 자식부터 다시 탐색 (1로 이동)
                x.left = removeNode(x.left, key);
            } else if (x.right != null) {
                // TODO : 삭제할 노드의 우측 서브 트리 중 가장 작은 키를 가진 노드를 찾는다.
                Node successor = getSmallestNode(x.right);
                // TODO : 삭제할 키와 우측 서브 트리 중 가장 작은 키를 Swap
                int removeKey = x.key;
                x.key = successor.key;
                successor.key = removeKey;
                // TODO : 삭제할 노드의 우측 자식부터 다시 탐색 (1로 이동)
                x.right = removeNode(x.right, key);
            } else {
                // TODO : null을 반환하여 연결을 끊는다.
                return null;
            }
        }
        return x;
    }

    private Node getLargestNode(Node x) {
        if (x.right == null) {
            return x;
        }
        return getLargestNode(x.right);
    }

    private Node getSmallestNode(Node x) {
        if (x.left == null) {
            return x;
        }
        return getSmallestNode(x.left);
    }

    public int search(int key) {
        return searchNode(root, key).key;
    }

    private Node searchNode(Node x, int key) {
        Node node = x;
        if (node == null) {
            throw new RuntimeException("노드를 찾을 수 없습니다.");
        } else if (node.key > key) {
            node = searchNode(x.left, key);
        } else if (node.key < key) {
            node = searchNode(x.right, key);
        }
        return node;
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

    public void traversal() {
        inorderTraversal(root);
        System.out.println("");
    }

    private void inorderTraversal(Node x) {
        // TODO : 중위 순회
        if (null == x) {
            return;
        }
        inorderTraversal(x.left);
        System.out.printf("%d ", x.key);
        inorderTraversal(x.right);
    }
}
