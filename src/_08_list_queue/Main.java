package _08_list_queue;

public class Main {
    public static void main(String[] args) {

        ListQueue listQueue = new ListQueue();
        System.out.println("1 추가");
        listQueue.add("1");
        System.out.println("2 추가");
        listQueue.add("2");
        System.out.println("3 추가");
        listQueue.add("3");
        System.out.println(listQueue);

        System.out.printf("poll : %s\n", listQueue.poll());
        System.out.println(listQueue);

        System.out.println("4 추가");
        listQueue.add("4");
        System.out.println(listQueue);

        System.out.printf("poll : %s\n", listQueue.poll());
        System.out.printf("poll : %s\n", listQueue.poll());
        System.out.println(listQueue);

        System.out.println("5 추가");
        listQueue.add("5");
        System.out.println("6 추가");
        listQueue.add("6");
        System.out.println(listQueue);

        System.out.printf("poll : %s\n", listQueue.poll());
        System.out.println(listQueue);

        System.out.printf("poll : %s\n", listQueue.poll());
        System.out.printf("poll : %s\n", listQueue.poll());
        System.out.println(listQueue);

    }
}
