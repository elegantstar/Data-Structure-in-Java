package _07_circle_queue;

public class Main {
    public static void main(String[] args) {

        CircleQueue circleQueue = new CircleQueue(3);
        System.out.println("1 추가");
        circleQueue.add("1");
        System.out.println("2 추가");
        circleQueue.add("2");
        System.out.println("3 추가");
        circleQueue.add("3");
        System.out.println(circleQueue);

        System.out.printf("poll : %s\n", circleQueue.poll());
        System.out.println(circleQueue);

        System.out.println("4 추가");
        circleQueue.add("4");
        System.out.println(circleQueue);

        System.out.printf("poll : %s\n", circleQueue.poll());
        System.out.printf("poll : %s\n", circleQueue.poll());
        System.out.println(circleQueue);

        System.out.println("5 추가");
        circleQueue.add("5");
        System.out.println("6 추가");
        circleQueue.add("6");
        System.out.println(circleQueue);

        System.out.printf("poll : %s\n", circleQueue.poll());
        System.out.println(circleQueue);

        System.out.printf("poll : %s\n", circleQueue.poll());
        System.out.printf("poll : %s\n", circleQueue.poll());
        System.out.println(circleQueue);

    }
}
