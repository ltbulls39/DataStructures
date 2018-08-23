import datastructures.BinaryMinHeap;
import datastructures.BinarySearchTree;

public class App {

    private static int parent(int x ) {
        return (x - 1) >> 1;
    }

    private static int leftChild(int x) {
        return (x * 2) + 1;
    }

    private static int rightChild(int x) {
        return (x * 2) + 2;
    }

    public static void main(String[] args) {
        BinaryMinHeap heap = new BinaryMinHeap();

        heap.offer(6);
        heap.offer(4);
        heap.offer(2);
        heap.offer(15);
        heap.offer(81);
        heap.offer(9);
        heap.offer(1);
        heap.offer(5);

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        heap.clear();
    }
}
