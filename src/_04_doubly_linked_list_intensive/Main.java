package _04_doubly_linked_list_intensive;

import java.util.ArrayList;
import java.util.List;

import _04_doubly_linked_list_intensive.ex1.DoublyLinkedList;
import _04_doubly_linked_list_intensive.ex2.NodeDoublyLinkedList;

public class Main {
    public static void main(String[] args) {

        // TODO : List 인터페이스 구현 이중 연결 리스트
        System.out.println("---List 인터페이스 구현 이중 연결 리스트---");
        List<String> list = new DoublyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);

        list.remove("c");
        System.out.println(list);

        List<String> tempList = new ArrayList<>();
        tempList.add("z");
        tempList.add("x");
        tempList.add("y");
        list.addAll(tempList);

        System.out.println(list);

        list.clear();
        System.out.println(list);

        // TODO : head, tail 노드 있는 이중 연결 리스트
        System.out.println("\n---head, tail node 존재 이중 연결 리스트---");
        NodeDoublyLinkedList nodeDoublyLinkedList = new NodeDoublyLinkedList();
        nodeDoublyLinkedList.add(0, "A");
        System.out.println(nodeDoublyLinkedList);

        nodeDoublyLinkedList.add(1, "B");
        System.out.println(nodeDoublyLinkedList);

        nodeDoublyLinkedList.add(2, "C");
        System.out.println(nodeDoublyLinkedList);

        System.out.printf("노드의 개수:%d\n", nodeDoublyLinkedList.size());
    }
}
