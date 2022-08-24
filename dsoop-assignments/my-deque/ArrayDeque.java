//Collaborator: Suppachoke Areechitsakul, Sumet Saelow, Nutchapol Isariyapruit
// * Name Suppachoke Areechitsakul
// * Student ID 6281553
import java.util.Arrays;

public class ArrayDeque<T> {
    private T[] data;
    private int size;

    // Creates an empty array deque.
    public ArrayDeque(){
        data = (T[]) new Object[1];

    }
    // Creates a deep copy of other.
    public ArrayDeque(ArrayDeque other){
        T[] copydeque = (T[]) new Object[1];
        System.arraycopy(other,0,copydeque,0,size);


    }
    // Adds an item of type T to the front of the deque.
    public void addFirst(T item){
        T firstindex,secondindex;
        firstindex = data[0];
        size++;
        for (int i = 0; i < size; i++){

            if (size >= data.length){
                grow(size+1);
            }
            secondindex = data[i+1];
            data[i+1] = firstindex;
            firstindex = secondindex;
        }
        data[0] = item;
    }
    // Adds an item of type T to the back of the deque.
    public void addLast(T item){
        if (size >= data.length){
            grow(size+2);
        }
        data[size] = item;
        size++;

    }
    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty(){
        if(data.length == 0){
            return true;}
        else {
            return false;
        }
    }
    // Returns the number of items in the deque.
    public int size(){
        return size;
    }
    // Returns a string showing the items in the deque from first to last,
// separated by a space.
    public String toString(){
        String result = "";
        for(int i = 0; i < size;i++){
            result = result + data[i].toString();
        }
        return result;
    }
    // Removes and returns the item at the front of the deque.
// If no such item exists, returns null.
    public T removeFirst(){
        T itemToReturn =  data[1];
        for(int i =0; i < size; i++){
            data[i]  = data[i+1];
        }
        data[size-1] = null;
        size--;
        return  itemToReturn;
    }
    // Removes and returns the item at the back of the deque.
// If no such item exists, returns null.
    public T removeLast(){
        T itemToReturn = data[size-1];
        // action of removing the last item
        //items[size-1] = null; <- can't use this cause it is the primitive
        size --;
        data[size - 1] = null;
        return itemToReturn;
    }
    // Gets the item at the given index, where 0 is the front, 1 is the next item,
// and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        return data[index];
    }
    private void grow(int newCap){ // grows (and transfer data) items to newCap
        T[] newItems = (T[]) new Object[newCap];
        System.arraycopy(data,0, newItems,0,size);
        data = newItems;
    }

}
