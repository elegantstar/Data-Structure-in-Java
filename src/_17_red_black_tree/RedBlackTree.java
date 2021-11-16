package _17_red_black_tree;

import static _17_red_black_tree.Node.BLACK;
import static _17_red_black_tree.Node.RED;

/**
 * Red-Black Tree의 시간 복잡도
 * 검색 -> 평균: O(log n)
 * 삽입 -> 평균: O(log n)
 * 삭제 -> 평균: O(log n)
 */
public class RedBlackTree {

    private Node root;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            insertNode(root, newNode);
        }
        root.color = BLACK;
    }

    private void insertNode(Node x, Node newNode) {
        if (x.key > newNode.key && !isExist(x.left)) {
            // TODO : 새로운 노드의 키가 x 노드의 키보다 작고, x 노드의 좌측 자식 노드가 null인 경우
            // TODO : 새로운 노드를 x 노드의 좌측 자식 노드로 연결하고, x 노드를 새로운 노드의 부모 노드로 연결
            x.left = newNode;
            newNode.parent = x;
        } else if (x.key <= newNode.key && !isExist(x.right)) {
            // TODO : 새로운 노드의 키가 x 노드의 키보다 작고, x 노드의 좌측 자식 노드가 null인 경우
            // TODO : 새로운 노드를 x 노드의 좌측 자식 노드로 연결하고, x 노드를 새로운 노드의 부모 노드로 연결
            x.right = newNode;
            newNode.parent = x;
        } else if (x.key > newNode.key) {
            // TODO : 새로운 노드의 키가 x 노드의 키보다 작으면
            // TODO : x 노드의 좌측 자식 노드로 이동하여 노드 삽입 시도
            insertNode(x.left, newNode);
        } else {
            // TODO : 새로운 노드의 키가 x 노드의 키보다 크면
            // TODO : x 노드의 우측 자식 노드로 이동하여 노드 삽입 시도
            insertNode(x.right, newNode);
        }
        // TODO : 노드 삽입 후 재배치
        insertFixUp(x);
    }

    private boolean isRed(Node x) {
        // TODO : null 노드가 아닌 x 노드의 색이 레드이다.
        return isExist(x) && RED == x.color;
    }

    private boolean isBlack(Node x) {
        // TODO : x 노드가 null 노드(leaf)이거나 x 노드의 색이 블랙이다.
        return !isExist(x) || BLACK == x.color;
    }

    private boolean isExist(Node x) {
        return x != null;
    }

    private void insertFixUp(Node g) {
        if (isRed(g.right) && isRed(g.right.left) && isBlack(g.left)) {
            // TODO : 삼촌 노드가 블랙이고, 우측-좌측 더블 레드인 경우
            // TODO : RL 회전
            LL_rotate(g.right);
            swapColor(g, g.right);
            RR_rotate(g);
        } else if (isRed(g.right) && isRed(g.right.right) && isBlack(g.left)) {
            // TODO : 삼촌 노드가 블랙이고, 우측-우측 더블 레드인 경우
            // TODO : RR 회전
            swapColor(g, g.right);
            RR_rotate(g);
        } else if (isRed(g.right) && (isRed(g.right.right) || isRed(g.right.left))) {
            // TODO : 삼촌 노드가 빨강이고, 우측-우측 더블 레드이거나 우측-좌측 더블 레드인 경우
            // TODO : recoloring (조부모 색깔을 레드로, 삼촌과 부모의 색깔을 블랙으로)
            g.color = RED;
            g.right.color = BLACK;
            g.left.color = BLACK;
        } else if (isRed(g.left) && isRed(g.left.right) && isBlack(g.right)) {
            // TODO : 삼촌 노드가 블랙이고, 좌측-우측 더블 레드인 경우
            // TODO : LR 회전
            RR_rotate(g.left);
            swapColor(g, g.left);
            LL_rotate(g);
        } else if (isRed(g.left) && isRed(g.left.left) && isBlack(g.right)) {
            // TODO : 삼촌 노드가 블랙이고, 좌측-좌측 더블 레드인 경우
            // TODO : LL 회전
            swapColor(g, g.left);
            LL_rotate(g);
        } else if (isRed(g.left) && (isRed(g.left.left) || isRed(g.left.right))) {
            // TODO : 삼촌 노드가 빨강이고, 좌측-좌측 더블 레드이거나 좌측-우측 더블 레드인 경우
            // TODO : recoloring (조부모 색깔을 레드로, 삼촌과 부모의 색깔을 블랙으로)
            g.color = RED;
            g.left.color = BLACK;
            g.right.color = BLACK;
        }
    }

    private void swapColor(Node nodeA, Node nodeB) {
        // TODO : nodeA와 nodeB의 색깔을 서로 바꾼다.
        int color = nodeA.color;
        nodeA.color = nodeB.color;
        nodeB.color = color;
    }

    public void remove(int key) {
        // TODO : 루트 노드부터 키를 비교하며 삭제할 노드를 찾아 삭제
        removeNode(root, key);
    }

    public void removeNode(Node x, int key) {
        if (x == null) {
            throw new RuntimeException("키를 찾을 수 없습니다.");
        } else if (x.key > key) {
            // TODO : 삭제하려는 키가 x 노드의 키 보다 작은 경우,
            // TODO : x 노드의 좌측 자식 노드로 이동하여 삭제 시도
            removeNode(x.left, key);
        } else if (x.key < key) {
            // TODO : 삭제하려는 키가 x 노드의 키 보다 큰 경우,
            // TODO : x 노드의 우측 자식 노드로 이동하여 삭제 시도
            removeNode(x.right, key);
        } else {
            if (isExist(x.left)) {
                // TODO : 삭제하려는 키를 가진 x 노드의 좌측 자식 노드가 null 노드가 아닌 경우
                // TODO : x 노드의 서브 트리에 존재하는 key 중 가장 큰 값(가장 우측 노드의 key)을 x 노드의 key 값과 치환한다.
                // TODO : 즉, 삭제하고자 하는 key는 x 노드의 서브 트리 중 가장 우측 leaf node 에 위치하게 된다.
                Node predecessor = getLargestNode(x.left);
                int removeKey = x.key;
                x.key = predecessor.key;
                predecessor.key = removeKey;
                // TODO : x 노드의 좌측 자식 노드로 이동하여 삭제 시도
                removeNode(x.left, predecessor.key);
            } else if (isExist(x.right)) {
                // TODO : 삭제하려는 키를 가진 x 노드의 우측 자식 노드가 null 노드가 아닌 경우
                // TODO : x 노드의 서브 트리에 존재하는 key 중 가장 작은 값(가장 좌측 노드의 key)을 x 노드의 key 값과 치환한다.
                // TODO : 즉, 삭제하고자 하는 key는 x 노드의 서브 트리 중 가장 좌측에 위치하게 된다.
                Node successor = getSmallerNode(x.right);
                int removeKey = x.key;
                x.key = successor.key;
                successor.key = removeKey;
                // TODO : x 노드의 우측 자식 노드로 이동하여 삭제 시도
                removeNode(x.right, successor.key);
            } else {
                // x 노드가 삭제할 노드
                if (root == x) {
                    root = null;
                } else {
                    if (isBlack(x)) {
                        removeFixUp(x);
                    }
                    // TODO : x 노드가 부모 노드의 좌측 자식인지 우측 자식인지 확인하여 연결 해제
                    if (x.parent.left == x) {
                        x.parent.left = null;
                    } else if (x.parent.right == x) {
                        x.parent.right = null;
                    }
                    x.parent = null;
                }
            }
        }
    }

    private void removeFixUp(Node x) {
        // TODO : black Leaf 를 삭제하면 조정해야 함
        while (x != root && isBlack(x)) {
            // TODO : 우측이 형제 노드
            if (x == x.parent.left) {
                Node w = x.parent.right;
                if (isRed(w)) {
                    // TODO : case 1 - 삭제할 노드의 형제 노드가 레드
                    /**
                     * 1. 삭제할 노드의 서브 트리 개수가 부족하므로, 부모 노드의 색깔과 형제 노드의 색깔을 Swap
                     * 2. 형제 노드를 축으로 AVL 트리의 RR 회전과 같은 Left-Rotation을 한다.
                     * Case1의 재배치 이후, 경로 상 검정 노드의 개수가 동일하지 않은 문제가 발생하여
                     * 추가적인 재배치가 필요 (Case2, Case3, Case4 의 상황으로 이어질 수 있다.)
                     */
                    w.color = BLACK;
                    x.parent.color = RED;
                    RR_rotate(x.parent);
                    w = x.parent.right;
                }
                if (isBlack(w.left) && isBlack(w.right)) {
                    // TODO : case 2 - 삭제할 노드의 형제 노드의 자식 노드가 모두 블랙
                    /**
                     * 형제 노드의 자식 노드 색깔이 모두 블랙인 경우는 NULL 노드 또는 데이터가 존재하는 블랙 노드인 경우.
                     * 1. 우측 서브 트리의 검정 노드 개수를 줄이기 위해 형제 노드의 색깔을 레드로 변경
                     * 2. 반대편 서브 트리 균형이 맞지 않을 수 있으므로, 상위 노드로 올라가서 변경된 상황(Case)에 따라 문제 해결
                     */
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (isBlack(w.right)) {
                        // TODO : case 3 - 삭제할 노드의 형제 노드의 좌측 자식이 레드, 우측 자식이 블랙
                        /**
                         * 1. 형제 노드의 색깔과 좌측 자식 노드의 색깔을 Swap
                         * 2. 형제 노드의 좌측 자식 노드를 축으로 AVL 트리의 LL 회전과 같은 Right-Rotation을 한다.
                         * 3. Case 3의 문제를 해결하면 반드시 Case 4의 상황으로 이어진다.
                         */
                        w.left.color = BLACK;
                        w.color = RED;
                        LL_rotate(w);
                        w = x.parent.right;
                    }
                    // TODO : case 4 - 삭제할 노드의 형제 노드의 우측 자식이 레드, 좌측 자식은 색깔 무관
                    /**
                     * 1. 부모 노드의 색깔과 형제 노드의 색깔을 Swap
                     * 2. 형제 노드를 축으로 AVL 트리의 RR 회전과 같은 Left-Rotation을 한다.
                     * Case 4의 상황이 해결되면 트리의 경로 상 검정 노드의 개수가 동일하게 된다.
                     */
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    RR_rotate(x.parent);
                    break;
                }
            } else if (x == x.parent.right) {
                // TODO : 우측이 형제 노드
                Node w = x.parent.left;
                if (isRed(w)) {
                    // TODO : case 1 - 삭제할 노드의 형제 노드가 레드
                    w.color = BLACK;
                    x.parent.color = RED;
                    LL_rotate(x.parent);
                    w = x.parent.left;
                }
                if (isBlack(w.left) && isBlack(w.right)) {
                    // TODO : case 2 - 삭제할 노드의 형제 노드의 자식 노드가 모두 블랙
                    w.color = RED;
                    x = x.parent;
                } else {
                    if (isBlack(w.left)) {
                        // TODO : case 3 - 삭제할 노드의 형제 노드의 좌측 자식이 레드, 우측 자식이 블랙
                        w.right.color = BLACK;
                        w.color = RED;
                        RR_rotate(w);
                        w = x.parent.left;
                    }
                    // TODO : case 4 - 삭제할 노드의 형제 노드의 우측 자식이 레드, 좌측 자식은 색깔 무관
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    LL_rotate(x.parent);
                    break;
                }
            }
        }
        // 변경된 x가 루트 노드이면서 빨강 노드인 경우가 있기 때문에
        // 마지막으로 x 노드를 검정 노드로 변경한다.
        x.color = BLACK;
    }

    private Node getLargestNode(Node x) {
        if (x.right == null) {
            return x;
        }
        return getLargestNode(x.right);
    }

    private Node getSmallerNode(Node x) {
        if (x.left == null) {
            // TODO : 좌측 자식 노드가 존재하지 않는다. (가장 작은 노드)
            return x;
        }
        return getSmallerNode(x.left);
    }

    public int search(int key) {
        // TODO : 루트 노드부터 키를 비교하며 재귀적으로 탐색
        return searchNode(root, key).key;
    }

    private Node searchNode(Node parent, int key) {
        if (parent == null) {
            throw new RuntimeException("노드를 찾을 수 없습니다.");
        } else if (parent.key > key) {
            // TODO : 찾고자 하는 키가 parent의 키보다 작으면 좌측 자식 노드로 이동하여 탐색
            parent = searchNode(parent.left, key);
        } else if (parent.key < key) {
            // TODO : 찾고자 하는 키가 parent의 키보다 크면 우측 자식 노드로 이동하여 탐색
            parent = searchNode(parent.right, key);
        }
        return parent;
    }

    private void LL_rotate(Node P) {
        /**
         * 축(L)을 중심으로 우측으로 끌어당긴다.
         *     GP(?) or GP(?)    GP(?) or GP(?)
         *         ↘    ↙          ↘    ↙
         *          P(4)    =>      L(2)
         *        ↙                ↙    ↘
         *     L(2)             LL(1)    P(4)
         *    ↙    ↘                    ↙
         * LL(1)   LR(3)            LR(3)
         */
        // TODO : 아래 (부모 -> 자식)로 향하는 포인터 재설정
        Node GP = P.parent;
        Node L = P.left;
        Node LR = L.right;
        L.right = P;
        P.left = LR;

        // TODO : 위 (자식 -> 부모)로 향하는 포인터 재설정
        P.parent = L;
        if (isExist(LR)) {
            LR.parent = P;
        }

        // TODO : 위 (부모 -> 조부모)로 향하는 포인터 재설정
        L.parent = GP;

        // TODO : 아래 (조부모 -> 부모)로 향하는 포인터 재설정
        if (!isExist(GP)) {
            this.root = L;
        } else {
            /**
             * 만약에 조부모가 있을 경우, 부모가 조부모의 어느 자식(좌, 우)인지 모른다.
             * 조부모의 이전 자식이 부모 노드였으므로 동일한 링크를 찾으면
             * 조부모의 어느 자식(좌, 우)인지 찾을 수 있다.
             */
            if (GP.right == P) {
                GP.right = L;
            } else if (GP.left == P) {
                GP.right = L;
            }
        }

    }

    private void RR_rotate(Node P) {
        /**
         * 축을(R) 중심으로 좌측으로 끌어당긴다.
         * GP(?) or GP(?)       GP(?) or GP(?)
         *     ↘    ↙               ↘    ↙
         *      P(1)        =>       R(3)
         *         ↘                ↙    ↘
         *          R(3)        P(1)      RR(4)
         *         ↙    ↘           ↘
         *      RL(2)   RR(4)        RL(2)
         */
        // TODO : 아래 (부모 -> 자식)로 향하는 포인터 재설정
        Node GP = P.parent;
        Node R = P.right;
        Node RL = R.left;
        R.left = P;
        P.right = RL;

        // TODO : 위 (자식 -> 부모)로 향하는 포인터 재설정
        P.parent = R;
        if (isExist(RL)) {
            RL.parent = P;
        }

        // TODO : 위 (부모 -> 조부모)로 향하는 포인터 재설정
        R.parent = GP;

        // TODO : 아래 (조부모 -> 부모)로 향하는 포인터 재설정
        if (!isExist(GP)) {
            this.root = R;
        } else {
            /**
             * 만약에 조부모가 있을 경우, 부모가 조부모의 어느 자식(좌,우)인지 모른다.
             * 조부모의 이전 자식이 부모 노드였으므로 동일한 링크를 찾으면
             * 조부모의 어느 자식(좌,우)인지 찾을 수 있다.
             */
            if (GP.right == P) {
                GP.right = R;
            } else if (GP.left == P) {
                GP.left = R;
            }
        }
    }

    private void printHelper(Node root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.color == RED ? "RED" : "BLACK";
            System.out.println(root.key + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }

    public void printTree() {
        printHelper(this.root, "", true);
    }

    public void traversal() {
        inorderTraversal(root);
        System.out.println("");
    }

    private void inorderTraversal(Node node) {
        if (null == node) {
            return;
        }
        inorderTraversal(node.left);
        System.out.printf("%d ", node.key);
        inorderTraversal(node.right);
    }

}
