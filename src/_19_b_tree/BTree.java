package _19_b_tree;

public class BTree {
    /**
     * B-Tree
     * t는 페이지 또는 Block의 크기. 임의로 사용하고 싶다면 원하는 값을 넣으면 된다.
     *
     * 각 노드당 가질 수 있는 키의 범위
     * 1) t-1 <= key <= 2t-1
     * Root 노드는 최소 key 제한을 받지 않는다.
     * Leaf 노드 또는 내부 노드의 크기가 t-1 보다 작아지면 병합을 하고, 2t-1보다 커지면 분할을 한다.
     *
     * 각 노드당 가질 수 있는 자식 노드의 범위
     * 2) t <= childNodes <= 2t
     * key의 개수에 따라 각 노드당 가질 수 있는 자식의 범위가 다르다.
     * key의 개수를 k라고 하면 항상 각 노드는 k+1의 자식 노드를 가진다.
     */

    private final int t;
    private Node root;

    public BTree(int t) {
        this.t = t;
    }

    public void add(int key) {
        if (root == null) {
            root = new Node(t);
            root.keys.add(key);
        } else {
            root = insertKey(root, key);
        }
    }

    private Node insertKey(Node x, int key) {
        int keyIndex = findKeyIndex(x, key);
        if (keyIndex < x.keys.size() && x.keys.get(keyIndex) == key) {
            throw new RuntimeException("동일한 키 존재");
        }
        if (isLeafNode(x)) {
            x.keys.add(keyIndex, key);
        } else {
            /**
             * x ->    |..| (parent)
             * y ->  |..|..| (child)
             */
            Node y = insertKey(x.nodes.get(keyIndex), key);
            if (y.keys.size() == 2 * t) {
                // TODO : Not root, overfull Node (split 필요)
                x = splitNode(x, y, keyIndex);
            }
        }
        if (x == root && x.keys.size() == 2 * t) {
            // TODO : Root, overfull Node (split 필요)
            Node newRoot = new Node(t);
            x = splitNode(newRoot, x, 0);
        }
        return x;
    }

    private Node splitNode(Node x, Node y, int yNodeIndex) {
        /**
         * x: 부모 노드
         * y: 자식 노드
         * yNodeIndex: y 노드가 x 노드의 몇 번째 자식인지 알 수 있는 index
         *
         * 분할
         * t = 2
         * 1(t-1) <= keys <= 3 (2t-1)
         * 분할 조건: keys == 4 (2t)
         * 중간값(medianKey) = t
         *
         * Ex1. 루트인 경우
         * (1)
         *  x ->   | |
         *  y -> |1|2|3|
         * (2)
         *  x ->   |2|
         *        ↙   ↘
         *  y -> |1| |3| <- z
         *
         * Ex2. 루트가 아닌 경우
         * (1)
         *  x ->   |2|
         *        ↙   ↘
         *  y -> |1| |3|4|5|
         * (2)
         *  x ->    |2|4|
         *         ↙  ↓    ↘
         *  y -> |1| |3|<-z |5|
         */

        Node z = new Node(t);
        int medianKey = y.keys.get(t);
        int yKeySize = y.keys.size();
        int yChildrenSize = y.nodes.size();

        // TODO : 새로운 노드에 키 복사
        z.keys.addAll(y.keys.subList(t + 1, yKeySize));
        // TODO : 기존 노드에 키 제거
        y.keys.subList(t, yKeySize).clear();

        if (!y.nodes.isEmpty()) {
            // TODO : 새로운 노드에 자식 노드 연결
            z.nodes.addAll(y.nodes.subList(t + 1, yChildrenSize));
            // TODO : 기존 노드의 자식 노드 제거
            y.nodes.subList(t + 1, yChildrenSize).clear();
        }

        if (y == root) {
            // TODO : 새로운 root 노드 생성 후 중간키 삽입
            x.keys.add(medianKey);
            // TODO : 새로운 root 노드에 이전 root 노드, 새로운 노드 삽입
            x.nodes.add(y);
            x.nodes.add(z);
        } else {
            // TODO : 부모 노드에 중간키 삽입
            x.keys.add(yNodeIndex, medianKey);
            // TODO : 부모 노드에 새로운 노드 삽입
            x.nodes.add(yNodeIndex + 1, z);
        }

        return x;
    }

    public int search(int key) {
        Node node = searchNode(root, key);
        int keyIndex = node.keys.indexOf(key);
        return node.keys.get(keyIndex);
    }

    private Node searchNode(Node x, int key) {
        int keyIndex = x.keys.indexOf(key);
        if (keyIndex == -1) {
            if (isLeafNode(x)) {
                throw new RuntimeException("찾을 값이 존재하지 않습니다.");
            }
            // TODO : x 노드에서 key를 찾지 못한 경우 아래로 내려감
            int nodeIndex = findKeyIndex(x, key);
            return searchNode(x.nodes.get(nodeIndex), key);
        } else {
            return x;
        }
    }

    private boolean isLeafNode(Node x) {
        return x.nodes.isEmpty();
    }

    private int findKeyIndex(Node x, int key) {
        int i = 0;
        while (i < x.keys.size() && x.keys.get(i) < key) {
            i++;
        }
        return i;
    }

    public void traversal() {
        inorderTraversal(root);
        System.out.println("");
    }

    private void inorderTraversal(Node node) {
        // TODO : 중위 순회
        for (int i = 0; i < node.keys.size(); i++) {
            if (!node.nodes.isEmpty()) {
                inorderTraversal(node.nodes.get(i));
            }
            System.out.printf("%d ", node.keys.get(i));
        }
        if (!node.nodes.isEmpty()) {
            inorderTraversal(node.nodes.get(node.nodes.size() - 1));
        }
    }

    public void printTree() {
        printTree(root, 0, "");
    }

    private void printTree(Node node, int index, String indent) {
        printKey(node, index, indent);
        if (!isLeafNode(node)) {
            for (int i = 0; i < node.nodes.size(); i++) {
                printTree(node.nodes.get(i), i, indent + "  ");
            }
        }
    }

    private void printKey(Node node, int index, String indent) {
        if (root != node) {
            System.out.printf("%sㄴ[C%d] ", indent, index);
        } else {
            System.out.print(" [R] ");
        }
        for (int key : node.keys) {
            System.out.printf("%d ", key);
        }
        System.out.println("");
    }
}
