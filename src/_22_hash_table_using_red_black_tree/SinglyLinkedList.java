package _22_hash_table_using_red_black_tree;

public class SinglyLinkedList {

    private Node head;
    private int size;

    private Node findNode(Object key) {
        // TODO : 동일한 key의 노드를 찾는다.
        Node pointer = head;
        if (head == null) {
            return null;
        }
        do {
            // TODO : 동일한 키를 발견하면 해당 노드를 반환
            if (pointer.key.equals(key)) {
                return pointer;
            }
        } while ((pointer = pointer.next) != null);
        return null;
    }

    Object getValue(Object key) {
        Node node = findNode(key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }

    // TODO : LinkedList에서 Tree로 변경 시, LinkedList의 노드를 삭제하면서 Tree에 키와 값을 추가하기 위해
    // TODO : 맨 앞에서부터 노드를 삭제하는 메서드.
    Node removeFirst() {
        // TODO : 첫 번째 노드를 삭제하는 메서드
        Node node = head;
        if (head != null) {
            head = head.next;
            --size;
        }
        return node;
    }

    // TODO : 키와 함께 해시값을 저장하고 동일한 키가 존재할 경우 값을 덮어쓰고,
    // TODO : 동일한 키가 존재하지 않으면 리스트의 맨 마지막 노드로 추가하는 메서드.
    void add(int hash, Object key, Object value) {
        Node node = new Node(hash, key, value);

        if (head == null) {
            // TODO : 맨 처음 노드를 삽입하는 경우
            head = node;
            ++size;
        } else {
            Node pointer = head;
            do {
                if (pointer.key.equals(key)) {
                    // TODO : 삽입하려는 키와 pointer의 키가 같은 경우 pointer의 value를 입력 받은 value로 덮어 쓴다.
                    pointer.value = value;
                    break;
                } else if (pointer.next == null) {
                    // TODO : pointer의 next가 null인 경우, 삽입한다. pointer를 node와 연결.
                    pointer.next = node;
                    ++size;
                    break;
                } else {
                    // TODO : 위의 두 가지 경우에 해당하지 않으면 pointer를 다음 node로 이동한다.
                    pointer = pointer.next;
                }
            } while (true);
        }
    }

    void remove(Object key) {
        // TODO : 입력 받은 key에 해당하는 Node를 삭제한다.
        if (head != null && head.key.equals(key)) {
            // TODO : head가 null이 아니고 삭제하려는 키가 head의 키와 동일하다면 head를 삭제한다. 즉, head를 다음 노드로 변경.
            head = head.next;
            --size;
        } else {
            Node pointer = head;
            // TODO : 다음 노드가 null이 아니고, 삭제하려는 키와 동일한 키가 아니라면 포인터를 이동
            while (pointer.next != null && !pointer.next.key.equals(key)) {
                pointer = pointer.next;
            }
            // TODO : 다음 노드가 null이 아니고, 삭제하려는 키와 동일한 키라면 노드의 연결을 끊는다.
            if (pointer.next != null && pointer.next.key.equals(key)) {
                pointer.next = pointer.next.next;
                --size;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node pointer = head;
        stringBuilder.append("head").append(" -> ");
        while (null != pointer) {
            stringBuilder.append("(").append(pointer.key).append(",").append(pointer.value).append(")").append(" -> ");
            pointer = pointer.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

}
