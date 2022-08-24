import java.util.LinkedList;

public class LinkedListDeque<T> extends LinkedList<T> implements Deque<T> {

    @Override
    public T getFirst() {
        return super.getFirst();
    }

    @Override
    public T getLast() {
        return super.getLast();
    }

    @Override
    public T removeFirst() {
        return super.removeFirst();
    }

    @Override
    public T removeLast() {
        return super.removeLast();
    }

    @Override
    public void addFirst(T t) {
        super.addFirst(t);
    }

    @Override
    public void addLast(T t) {
        super.addLast(t);
    }

    @Override
    public T get(int index) {
        return super.get(index);
    }
}