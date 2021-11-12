package _02_singly_linked_list_intensive;

import _02_singly_linked_list_intensive.generic_list.GenericSinglyLinkedList;
import _02_singly_linked_list_intensive.head_node_list.HeadNodeSinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        // TODO : 제네릭 적용 단일 연결 리스트
        GenericSinglyLinkedList<String> list = new GenericSinglyLinkedList<>();

        list.addLast("A");
        System.out.println(list);

        list.addLast("B");
        System.out.println(list);

        list.addLast("C");
        System.out.println(list);

        list.addLast("D");
        System.out.println(list);

        // TODO : 주석을 풀면 incompatibe type 컴파일 에러 발생!
        // list.addLast(1);

        System.out.println("---Head Node 있는 리스트---");

        // TODO : Head Node 있는 단일 연결 리스트
        HeadNodeSinglyLinkedList headNodeList = new HeadNodeSinglyLinkedList();

        headNodeList.addLast("B");
        System.out.println(headNodeList);

        headNodeList.addFirst("A");
        System.out.println(headNodeList);

        headNodeList.addLast("E");
        System.out.println(headNodeList);

        headNodeList.add(1, "C");
        System.out.println(headNodeList);

        headNodeList.add(2, "D");
        System.out.println(headNodeList);

        headNodeList.removeLast();
        System.out.println(headNodeList);

        headNodeList.remove(1);
        System.out.println(headNodeList);

        headNodeList.removeFirst();
        System.out.println(headNodeList);

        System.out.printf("노드의 개수: %d\n", headNodeList.size());

        System.out.printf("1번 인덱스의 값:%s", headNodeList.getData(1));
    }
}
