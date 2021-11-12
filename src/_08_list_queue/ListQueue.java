package _08_list_queue;

public class ListQueue {

    private Node front;
    private Node rear;

    public boolean isEmpty() {
        return null == front;
    }

    public void add(Object data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            // TODO : 최초 노드 삽입 시
            front = rear = newNode;
        } else {
            // TODO : 이미 노드가 존재할 때 맨 마지막 노드로 추가한다.
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        // TODO : 항상 삭제될 노드는 front가 가리키는 노드이다.
        Node removeNode = front;
        Object tempData = removeNode.data;
        front = removeNode.next;

        // TODO : 삭제될 노드가 맨 마지막 노드라면 rear의 연결을 끊는다.
        if (removeNode == rear) {
            rear = null;
        }
        return tempData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cursor = front;
        builder.append("앞").append("->");
        while (null != cursor) {
            builder.append(cursor.data).append("->");
            cursor = cursor.next;
        }
        builder.append("뒤");
        return builder.toString();
    }

}
