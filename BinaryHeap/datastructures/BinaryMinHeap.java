package datastructures;

public class BinaryMinHeap implements IHeap{
    private int[] heap;
    private int size;

    /**
     * Equations
     *      - Parent      = (index - 1) >> 1
     *      - Left child  = (index * 2) + 1
     *      - Right child = (index * 2) + 2
     */

    public BinaryMinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public BinaryMinHeap() {
        this(DEFAULT_MAX_CAPACITY);
    }

    @Override
    public void clear() {
        heap = new int[heap.length];
        size = 0;
    }

    @Override
    public int poll() throws IndexOutOfBoundsException{
        if (isEmpty()) throw new IndexOutOfBoundsException();
        int toRet = heap[0];
        swap(0, size - 1);
        size--;
        bubbleDown();
        return toRet;
    }

    private void bubbleDown() {
        int index = 0;
        while (hasChild(index)) {
            int child = selectChild(index);
            if (heap[index] > child) {
                swap(index, child);
            }
            index = child;
        }
    }

    /**
     * Selects the child of a given Node
     *
     * @param index
     * @return index of the selected child
     */
    private int selectChild(int index) {
        int left = (index * 2) + 1;
        int right = (index * 2) + 2;

        if (isChild(left) && isChild(right)) {
            if (heap[left] < heap[right])
                return left;
            return right;
        }

        if (isChild(left))
            return left;

        return right;
    }

    private boolean isChild(int index) {
        return index < size;
    }

    private boolean hasChild(int index) {
        int left = (index * 2) + 1;
        int right = (index * 2) + 2;

        return left < size || right < size;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void offer(int insert) {
        if (!ensureCapacity())
            return;
        heap[size++] = insert;
        bubbleUp();
    }

    private boolean hasParent(int index) {
        return (index - 1) >> 1 >= 0;

    }

    private int parent(int index) {
        return (index - 1) >> 1;
    }

    /**
     * Swaps two elements, takes in the indices of the elements to swap
     * @param left
     * @param right
     * @return
     */
    private int swap(int left, int right) {
        int temp = heap[left];
        heap[left] = heap[right];
        heap[right] = temp;
        return left;
    }

    private void bubbleUp() {
//        Off by one possibility
        int index = size - 1;
        while (hasParent(index)) {
            if (heap[parent(index)] > heap[index])
                index = swap(parent(index), index);
            else break;
        }

    }

    private boolean ensureCapacity() {
        return !(size == heap.length);
    }


    @Override
    public String toString() {
        String toRet = "";
        for (int i = 0; i < size; i++) {
            toRet += heap[i] + " ";
        }

        return toRet;
    }
}
