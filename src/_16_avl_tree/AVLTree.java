package _16_avl_tree;

/**
 * AVL Tree의 시간 복잡도
 * 공간 -> 평균: O(n)
 * 검색 -> 평균: O(log n)
 * 삽입 -> 평균: O(log n)
 * 삭제 -> 평균: O(log n)
 */
public class AVLTree {

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
         * 이진 탐색 트리와 동일
         * 1. x 노드가 null일 때까지 x 노드의 데이터와 새로운 노드의 데이터를 비교한다.
         * 1-1. x 노드의 데이터 보다 작으면 좌측 노드로 이동한다.
         * 1-1-1. x 노드의 좌측 노드로 이동한다. (1로 이동)
         * 1-2. x 노드의 데이터 보다 크면 우측 노드로 이동한다.
         * 1-2-1. x 노드의 우측 노드로 이동한다. (1로 이동)
         * 2. x가 null이면 새로운 노드를 반환한다.
         * 3. 이전 분기점으로 돌아가는 방식으로 x 노드부터 높이를 재조정한다.
         * 4. 균형도가 맞지 않으면 회전시킨다.
         */

        if (x == null) {
            return newNode;
        } else if (x.key > newNode.key) {
            x.left = insertNode(x.left, newNode);
        } else {
            x.right = insertNode(x.right, newNode);
        }
        // TODO : 이전 분기점으로 돌아가는 방식으로 height 조정 후 회전
        changeNodeHeight(x);
        return rotate(x);
    }

    public void remove(int key) {
        root = removeNode(root, key);
    }

    private Node removeNode(Node x, int key) {
        /**
         * BST와 동일
         * 1. 삭제할 키를 찾는다.
         * 1-1 삭제할 키가 없으면 예외 처리
         * 2. 삭제할 키를 찾았으면 삭제할 노드의 좌/우측 자식을 확인 한다.
         * 2-1 좌측 노드가 null이 아니면 삭제할 노드의 좌측 서브 트리 중 가장 큰 키(predecessor data)를 가진 노드를 찾는다.
         * 2-1-1 삭제할 키와 가장 큰 키를 swap 한다
         * 2-1-2 삭제할 노드의 좌측 자식 부터 다시 탐색 (1로 이동)
         * 2-2 우측 노드가 null이 아니면 삭제할 노드의 우측 서브 트리 중 가장 작은 키(successor data)를 가진 노드를 찾는다.
         * 2-2-1 삭제할 키와 가장 작은 키를 swap 한다
         * 2-2-2 삭제할 노드의 우측 자식 부터 다시 탐색 (1로 이동)
         * 3. Leaf 노드이면 null을 반환하여 노드의 연결을 끊는다
         * 4. 이전 분기점으로 돌아가는 방식으로 x 노드 부터 높이를 재조정한다.
         * 5. 균형도가 맞지 않으면 회전시킨다.
         */
        if (x == null) {
            throw new RuntimeException("키를 찾을 수 없습니다.");
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
        // TODO : 이전 분기점으로 돌아가는 방식으로 height 조정 후 회전
        changeNodeHeight(x);
        return rotate(x);
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
            throw new RuntimeException("키를 찾을 수 없습니다.");
        } else if (node.key > key) {
            node = searchNode(x.left, key);
        } else if (node.key < key) {
            node = searchNode(x.right, key);
        }
        return node;
    }

    private Node rotate(Node x) {
        /**
         * 균형도가 2, 1이면 좌측 서브 트리 비대, -2, -1이면 우측 서브 트리 비대를 의미한다.
         * x 노드의 균형도가 2이면 왼쪽 자식의 균형도를 알아 본다.
         * 1) 왼쪽 자식의 균형도가 1이면 (LL)
         * 2) 왼쪽 자식의 균형도가 -1이면 (LR)
         * x 노드의 균형도가 -2이면 오른쪽 자식의 균형도를 알아 본다.
         * 1) 오른쪽 자식의 균형도가 1이면 (RL)
         * 2) 오른쪽 자식의 균형도가 -1이면 (RR)
         */
         int xNodeBalance = getBalance(x);

         // TODO :  균형도의 절대값이 2 이상이면 회전
        if (Math.abs(xNodeBalance) >= 2) {
            // TODO : 회전으로 인해 변경된 새로운 x 노드를 반환한다.
            if (xNodeBalance > 1 && getBalance(x.left) == 1) {
                // TODO : 좌측 서브트리가 더 비대하다. 그리고 왼쪽 자식의 균형도가 1이다.
                // TODO : LL 회전
                x = LL_rotate(x);
            } else if (xNodeBalance > 1 && getBalance(x.left) == -1) {
                // TODO : 좌측 서브트리가 더 비대하다. 그리고 왼쪽 자식의 균형도가 -1이다.
                // TODO : LR 회전
                x.left = RR_rotate(x.left);
                x = LL_rotate(x);
            } else if (xNodeBalance < -1 && getBalance(x.right) == -1) {
                // TODO : 우측 서브트리가 더 비대하다. 그리고 우측 자식의 균형도가 -1이다.
                // TODO : RR 회전
                x = RR_rotate(x);
            } else if (xNodeBalance < -1 && getBalance(x.right) == 1) {
                // TODO : 우측 서브트리가 더 비대하다. 그리고 우측 자식의 균형도가 1이다.
                // TODO : RL 회전
                x.right = LL_rotate(x);
                x = RR_rotate(x);
            }
        }
        return x;
    }

    private Node LL_rotate(Node P) {
        //          P(4)    =>      L(2)
        //        ↙                ↙    ↘
        //     L(2)             LL(1)    P(4)
        //    ↙    ↘                    ↙
        // LL(1)   LR(3)            LR(3)
        // 축(L)을 중심으로 우측으로 끌어당긴다.

        Node L = P.left;
        Node LR = L.right;
        L.right = P;
        P.left = LR;

        // TODO : 높이가 영향 받는 건 이전 부모 노드의 새로운 부모 노드 뿐이다.
        changeNodeHeight(P);
        changeNodeHeight(L);

        // TODO : 회전 후 새로운 부모 노드를 반환한다.
        return L;
    }

    private Node RR_rotate(Node P) {
        //     P(1)        =>       R(3)
        //        ↘                ↙    ↘
        //         R(3)        P(1)      RR(4)
        //        ↙    ↘           ↘
        //     RL(2)   RR(4)        RL(2)
        // 축(R)을 중심으로 좌측으로 끌어당긴다.

        Node R = P.right;
        Node RL = R.left;
        R.left = P;
        P.right = RL;

        // TODO : 높이가 영향을 받는 건 이전 부모 노드와 새로운 부모 노드 뿐이다.
        changeNodeHeight(P);
        changeNodeHeight(R);

        // TODO : 회전 후 새로운 부모 노드를 반환한다.
        return R;
    }

    private int getHeight(Node x) {
        /**
         * 높이 = Max(좌측 노드 높이, 우측 노드 높이) + 1
         * 만약에 노드가 없으면 높이를 -1로 계산
         */
        int leftChildHeight = (x.left != null) ? x.left.height : -1;
        int rightChildHeight = (x.right != null) ? x.right.height : -1;
        return Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    private int getBalance(Node x) {
        /**
         * 균형도 = 좌측 노드 높이 - 우측 노드 높이
         * 만약에 노드가 없으면 높이를 -1로 계산
         */
        int leftChildHeight = (x.left != null) ? x.left.height : -1;
        int rightChildHeight = (x.right != null) ? x.right.height : -1;
        return leftChildHeight - rightChildHeight;
    }

    private void changeNodeHeight(Node x) {
        // TODO : 자식 노드를 확인하여 노드의 높이를 변경한다.
        x.height = getHeight(x);
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

            System.out.println(x.key + "(h:" + x.height + ")");
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

    private void inorderTraversal(Node node) {
        // TODO : 중위 순회
        if (null == node) {
            return;
        }
        inorderTraversal(node.left);
        System.out.printf("%d ", node.key);
        inorderTraversal(node.right);
    }
}
