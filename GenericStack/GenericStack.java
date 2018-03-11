public class GenericStack<T> {
    private GenericNode<T> top;
    private int size = 0;

    public void push(T data) {
        GenericNode<T> newNode = new GenericNode<T>(data);
        if(top != null) {
            newNode.next = top;
        }
        top = newNode;
        size++;
    }

    public T pop() {
        if(top == null)
            return null;
        T temp = top.data;
        top = top.next;
        size--;              
        return temp;
    }

    public boolean empty() {
        if(top == null) 
            return true;
        return false;
    }

    public int size() {
        return this.size;
    }
}