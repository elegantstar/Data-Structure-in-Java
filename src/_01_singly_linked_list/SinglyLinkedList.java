package _01_singly_linked_list;

public class SinglyLinkedList {

    Node head;
    int size = 0;

    private Node findNode(int searchIndex) {
        /**
         *  찾는 노드의 index가 음수거나
         *  노드의 개수보다 많거나 같으면 예외를 발생시킨다.
         */
        if (0 > searchIndex || size <= searchIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int nodeIndex = 0;
        Node pointer = head;
        /**
         *  찾는  노드의 index와 노드의 순서가 동일할 때까지
         *  노드의 참조값을 이용하여 이동한다.
         */
        while (nodeIndex != searchIndex) {
            ++nodeIndex;
            pointer = pointer.next;
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
        // TODO : 마지막 노드로 추가하는  메서드
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

    public  void removeFirst() {
        // TODO : 첫 번째   노드를 삭제하는 메서드
        remove(0);
    }

    public void add(int index, Object data) {
        // TODO : 노드의 순서를 기준으로 해당 index에 삽입한다.
        Node node = new Node();
        node.data = data;

        if (0 == index) {
            // TODO : 맨  앞에 노드를 삽입하는  경우
            node.next = head;
            head = node;
        } else {
            // TODO : 해당 index에 삽입하려면 이전 노드를 찾아야 한다.
            Node foundNode = findNode(index - 1);
            node.next = foundNode.next;
            foundNode.next = node;
        }
        ++size;
    }

    public void remove(int index) {
        // TODO : 해당 index에 해당하는 Node를 삭제한다.
        if (0 == index && null != head) {
            head = head.next;
        } else {
            // TODO : 삭제하려는 Node의 이전 노드
            Node prevNode = findNode(index - 1);
            prevNode.next = prevNode.next.next;
        }
        --size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node pointer = head;
        stringBuilder.append("head").append(" -> ");
        while (null != pointer) {
            stringBuilder.append(pointer.data).append(" -> ");
            pointer = pointer.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }


}
