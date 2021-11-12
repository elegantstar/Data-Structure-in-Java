package _06_list_stack;

public class ListStack {

    private Node head;

    public boolean isEmpty() {
        return null == head;
    }

    public void push(Object data) {
        Node node = new Node();
        node.data = data;
        // TODO : 첫 노드가 아닐 때는 이미 있는 노드와 연결해야 한다.
        if (!isEmpty()) {
            // TODO : 새로운 노드는 head가 가리키는 노드의 참조값을 저장한다.
            node.next = head;
        }
        // TODO : head는 새로운 노드의 참조값을 저장한다.
        head = node;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        // TODO : 항상 삭제할 노드는 head가 가리키는 노드이다.
        Node removeNode = head;
        Object tempData = removeNode.data;
        head = removeNode.next;

        // TODO : 노드의 데이터를 삭제하고 연결을 끊는다.
        removeNode.data = null;
        removeNode.next = null;

        return tempData;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (isEmpty()) {
            return "Empty Stack";
        }
        builder.append("top").append(" | ");
        Node pointer = head;
        while (null != pointer) {
            builder.append(pointer.data).append(" | ");
            pointer = pointer.next;
        }
        builder.append("bottom");
        return builder.toString();
    }
}
