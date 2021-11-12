package _01_singly_linked_list;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast("B");
        System.out.println(list);

        list.addFirst("A");
        System.out.println(list);

        list.addLast("E");
        System.out.println(list);

        list.add(1, "C");
        System.out.println(list);

        list.add(2, "D");
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        System.out.printf("노드의 개수: %d\n", list.size());

        System.out.printf("1번 인덱스의 값: %s", list.getData(1));

    }
}
