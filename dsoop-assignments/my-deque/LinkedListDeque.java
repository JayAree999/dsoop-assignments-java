//Collaborator: Suppachoke Areechitsakul, Sumet Saelow, Nutchapol Isariyapruit
// * Name Suppachoke Areechitsakul
// * Student ID 6281553
public class LinkedListDeque<T> {


    public void printDeque() {
        toString();

    }

    private class Node {
        T data;
        Node next;
        Node prev;




        public Node(Node prev, T data, Node next) {

            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }


    private Node front;
    private Node rear;
    private int Size;


    public LinkedListDeque() {



        front = null;
        rear = null;

        Size = 0;


    }



//
//     Creates a deep copy of other.
    public LinkedListDeque(LinkedListDeque other){
        LinkedListDeque copy = new LinkedListDeque();
        Node front= other.front;

        while (front != null) {

            copy.addLast(front.data);
            System.out.println(copy.toString());

            front=front.next;


        }

        System.out.println(other.toString());



    }

    // Adds an item of type T to the front of the deque.

    public void addFirst(T item) {

//
//        Node newNode = new Node(null, item, front);
        if (Size==0) {
            Node newNode = new Node(null, item, null);
            front =newNode;
            rear=newNode;
        }
        else{
            Node newNode = new Node(null, item, front);
            front.prev= newNode;
            front=newNode;



        }

        Size++;



    }

    // Adds an item of type T to the back of the deque.
    public void addLast(T item) {


        if (Size==0) {
            Node newNode = new Node(null, item, null);
            front =newNode;
            rear=newNode;
        }
        else{
            Node newNode = new Node(rear, item, null);

            rear.next= newNode;
            rear=newNode;



        }
        Size++;



    }




    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        if (Size == 0){

            return true;


        }
        else{
            return false;
        }
    }
    // Returns the number of items in the deque.
    public int size() {

        return Size;

    }

    // Returns a string showing the items in the deque from first to last,
    // separated by a space.
    public String toString() {

        String total ="[";
        Node temp = front;
        while (temp != null) {


            total+=temp.data+", ";
            temp = temp.next;
        }
        return total+"]";


    }

    // Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        Node temp = front;

        if (front.next ==null){

            front=null;
            rear=null;
        }
        else{
            front=front.next;
        }

//        free()


//
//        if (front == null)
//            rear = null;
//        else
//            front.prev = null;




        Size--;

        return temp.data;

    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        Node temp = rear;

        if (rear.prev ==null){ // if there is only 1 element

            front=null;
            rear=null;
        }
        else{
            rear.prev=rear;
        }


        Size--;




        return temp.data;

    }


    // Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists, returns null. Must not alter the deque!
//    public T get(int index) {
//
//
//
//
//
//
//
//        }


}
