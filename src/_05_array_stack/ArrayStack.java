package _05_array_stack;

public class ArrayStack {

    private int top = -1;
    private final Object[] stack;

    public ArrayStack(int stackSize) {
        this.stack = new Object[stackSize];
    }

    public boolean isEmpty() {
        return -1 == top;
    }

    public boolean isFull() {
        return stack.length - 1 == top;
    }

    public void push(Object data) {
        if (isFull()) {
            throw new RuntimeException("stack is Full");
        }
        stack[++top] = data;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        Object tempData = stack[top];
        stack[top--] = null;
        return tempData;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (isEmpty()) {
            return "Empty Stack";
        }
        builder.append("bottom").append(" | ");
        for (int i = 0; i <= top; i++) {
            builder.append(stack[i]).append(" | ");
        }
        builder.append("top");
        return builder.toString();
    }
}
