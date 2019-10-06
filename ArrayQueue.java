import java.util.EmptyStackException;

public class ArrayQueue<T> implements Queue<T> {
    int head = 0, tail = 0;
    T[] a = (T[]) new Object[2];

    @Override
    public T dequeue() {
        if (empty())
            throw new EmptyStackException();
        T item = a[head];
        head = (head + 1) % a.length;
        return item;
    }

    @Override
    public void enqueue(T item) {
        if((tail + 1) % a.length == head)
            growArray();
        a[tail++] = item;
        tail = tail % a.length;
    }

    @Override
    public boolean empty() {
        return head == tail;
    }

    protected void growArray(){
        T[] temp = a;
        a = (T[]) new Object[a.length*2];
        System.arraycopy(temp, head, a,0, temp.length - head);
        System.arraycopy(temp, 0, a, temp.length -head, tail);
        head = 0;
        tail = temp.length-1;
    }
}
