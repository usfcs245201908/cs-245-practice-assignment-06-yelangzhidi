import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T>{
    int top = -1;
    T[] a = (T[]) new Object[10];

    @Override
    public void push(T item) {
        if(top == a.length-1)
            growArray();
        a[++top] = item;
    }

    @Override
    public T pop() {
        if (empty())
            throw new EmptyStackException();
        return a[top--];
    }

    @Override
    public T peek() {
        return a[top];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    protected void growArray(){
        T[] temp = a;
        a = (T[]) new Object[a.length*2];
        System.arraycopy(temp,0, a, 0, temp.length); // Arrays.copyOfRange();
    }
}
