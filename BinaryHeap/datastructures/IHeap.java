package datastructures;

public interface IHeap {
    int DEFAULT_MAX_CAPACITY = 100;

    void offer(int insert);

    void clear();

    boolean isEmpty();

    int poll();
}
