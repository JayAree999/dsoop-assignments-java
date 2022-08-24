public interface Deque<T> {

     T getFirst();


     T getLast();


     T removeFirst();


    T removeLast();


    void addFirst(T t);


    void addLast(T t);


     T get(int index);

}