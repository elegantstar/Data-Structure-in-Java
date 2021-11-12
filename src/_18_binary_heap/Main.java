package _18_binary_heap;

public class Main {
    public static void main(String[] args) {

        // TODO : 최대 Heap
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(4);
        maxHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(6);
        System.out.println("--Max Heap--");
        maxHeap.printTree();
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
        }

        // TODO : 최소 Heap
        MinHeap minHeap = new MinHeap();
        minHeap.add(4);
        minHeap.add(1);
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(6);
        System.out.println("--Min Heap-- ");
        minHeap.printTree();
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.remove());
        }
    }
}
