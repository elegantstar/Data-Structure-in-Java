package _04_doubly_linked_list_intensive.ex2;

public class NodeDoublyLinkedList {

    Node head = new Node();
    Node tail = new Node();
    int size = 0;

    public NodeDoublyLinkedList() {
        head.right = tail;
        tail.left = head;
    }

    public Node findNode(int searchIndex) {
        // TODO : 찾는 노드의 index가 음수거나 노드의 개수 보다 많거나 같으면 예외를 발생시킨다.
        if (0 > searchIndex || size < searchIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int nodeIndex;
        Node pointer;
        if (size / 2 > searchIndex) {
            // TODO : 앞에서부터 찾는다.
            nodeIndex = -1;
            pointer = head;
            while (nodeIndex != searchIndex) {
                ++nodeIndex;
                pointer = pointer.right;
            }
        } else {
            // TODO : 뒤에서부터 찾는다.
            nodeIndex = size;
            pointer = tail;
            while (nodeIndex != searchIndex) {
                --nodeIndex;
                pointer = pointer.left;
            }
        }
        return pointer;
    }

    public Object getData(int searchIndex) {
        return findNode(searchIndex).data;
    }

    public boolean isEmpty() {
        // TODO : 노드가 비어있는지 확인하는 메서드
        return 0 == size;
    }

    public int size() {
        // TODO : 노드의 개수를 반환하는 메서드
        return size;
    }

    public void addLast(Object data) {
        // TODO : 마지막 노드로 추가하는 메서드
        add(size, data);
    }

    public void addFirst(Object data) {
        // TODO : 첫 번째 노드로 추가하는 메서드
        add(0, data);
    }

    public void removeLast() {
        // TODO : 마지막 노드를 삭제하는 메서드
        remove(size - 1);
    }

    public void removeFirst() {
        // TODO : 첫 번째 노드 삭제하는 메서드
        remove(0);
    }

    public void add(int index, Object data) {

        // TODO : 노드의 순서를 기준으로 해당 index에 삽입한다.
        Node node = new Node();
        node.data = data;

        // TODO : 해당 index에 삽입하려면 해당 노드를 찾아야 한다.
        Node foundNode = findNode(index);
        Node leftNode = foundNode.left;
        // TODO : 새로운 노드와 찾은 노드의 연결
        node.right = foundNode;
        foundNode.left = node;
        // TODO : 새로운 노드와 이전 노드의 연결
        node.left = leftNode;
        leftNode.right = node;

        ++size;
    }

    public void remove(int index) {
        // TODO : 해당 index에 해당하는 Node를 삭제한다.

        // TODO : 삭제하려는 Node를 찾는다.
        Node foundNode = findNode(index);
        Node leftNode = foundNode.left;
        Node rightNode = foundNode.right;

        // TODO : 좌측 노드의 우측 노드를 우측 노드로 변경
        leftNode.right = rightNode;
        // TODO : 우측 노드의 좌측 노드를 좌측 노드로 변경
        rightNode.left = leftNode;

        // TODO : 삭제할 노드의 링크를 모두 끊는다.
        foundNode.left = null;
        foundNode.right = null;
        foundNode.data = null;

        --size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node pointer = head.right;
        stringBuilder.append("head").append(" -> ");
        while (tail != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.right;
        }
        stringBuilder.append("null ");
        if (head != tail.left) {
            stringBuilder.append(", tail(").append(tail.left.data).append("), ");
        }
        pointer = tail.left;
        stringBuilder.append("tail").append(" -> ");
        while (head != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.left;
        }
        stringBuilder.append("null");
        if (tail != head.right) {
            stringBuilder.append(", head(").append(head.right.data).append(")");
        }
        return stringBuilder.toString();
    }
}
