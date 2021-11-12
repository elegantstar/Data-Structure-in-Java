package _06_list_stack;

public class Main {
    public static void main(String[] args) {

        ListStack listStack = new ListStack();
        listStack.push("a");
        listStack.push("b");
        listStack.push("c");
        listStack.push("d");
        System.out.println(listStack);

        System.out.printf("Pop된 데이터 %s\n", listStack.pop());
        System.out.println(listStack);

        System.out.printf("Pop된 데이터 %s\n", listStack.pop());
        System.out.println(listStack);

        listStack.push("e");
        System.out.println(listStack);

        System.out.printf("Peak된 데이터 %s\n", listStack.peek());
        System.out.println(listStack);

    }
}
