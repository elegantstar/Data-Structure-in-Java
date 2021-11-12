package _05_array_stack;

public class Main {
    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");
        arrayStack.push("d");
        System.out.println(arrayStack);

        System.out.printf("Pop된 데이터 %s\n", arrayStack.pop());
        System.out.println(arrayStack);

        System.out.printf("Pop된 데이터 %s\n", arrayStack.pop());
        System.out.println(arrayStack);

        arrayStack.push("e");
        System.out.println(arrayStack);

        System.out.printf("Peak된 데이터 %s\n", arrayStack.peek());
        System.out.println(arrayStack);

    }
}
