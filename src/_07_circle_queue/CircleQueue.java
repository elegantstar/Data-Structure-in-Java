package _07_circle_queue;

public class CircleQueue {

    private final Object[] queue;

    private int front = 0;
    private int rear = 0;

    public CircleQueue(int size) {
        this.queue = new Object[size];
    }

    public void add(Object data) {
        if (front == rear && null != queue[rear]) {
            throw new RuntimeException("Queue is Full");
        }
        queue[rear] = data;
        ++rear;
        rear = rear % queue.length;
    }

    public Object poll() {
        if (front == rear && null == queue[front]) {
            return null;
        }
        Object data = queue[front];
        queue[front] = null;
        ++front;
        front = front % queue.length;

        return data;
    }

    public Object peek() {
        return queue[front];
    }

    @Override
    public String toString() {
        int tempFront = front;
        int tempRear = rear;
        StringBuilder builder = new StringBuilder();
        builder.append("앞").append("->");
        // TODO : front와 rear가 동일한 경우 두 가지가 경우가 있음
        // TODO : Queue가 비어있거나 또는 꽉 차있을 때
        if (tempFront == tempRear && null != queue[tempFront]) {
            builder.append(queue[tempFront]).append("->");
            ++tempFront;
            tempFront = tempFront % queue.length;
        }
        while (tempFront != tempRear) {
            builder.append(queue[tempFront]).append("->");
            ++tempFront;
            tempFront = tempFront % queue.length;
        }
        builder.append("뒤");
        return builder.toString();
    }
}
