import java.util.*;

public class MyPriorityQueue<T> implements IPriorityQueue<T> {


    private List<T> queueItems =new ArrayList<T>();
    private CompareWith<T> comparator;
//    private MyPriorityQueue<T> myq = new MyPriorityQueue<>(comparator);
    private int size;



    public MyPriorityQueue(CompareWith<T> cc) {
        comparator = cc;
        size =0;


    }


    @Override
    public void add(T item) {
        queueItems.add(item);
        size++;

    }

    @Override
    public void addAll(List<T> items) {



        queueItems.addAll(items);
        size+= items.size();
    }

    @Override
    public T getMinimum() {




//        myCollectionsCollections.sort(queueItems);

        System.out.println(queueItems.size());
        for (int i = 0; i< queueItems.size()-1;i++){

            if (comparator.lessThan(queueItems.get(i+1),queueItems.get(i))){

                T temp = queueItems.get(i);
                queueItems.set(i,queueItems.get(i+1));
                queueItems.set(i+1,temp);

                i=-1;




            }

        }


        return queueItems.get(0);
    }








    @Override
    public void removeMinimum() {
        queueItems.remove(getMinimum());
        size--;


    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> revIterator() {
      return new myrev();
    }
    class myrev implements Iterator{
        private int index;
        public myrev(){
            index=queueItems.size();
        }

        @Override
        public boolean hasNext() {
            return index>0;
        }

        @Override
        public Object next() {
            index--;
            return queueItems.get(index);
        }
    }





    public Iterator<T> iterator() {
        return new myIter();
    }

    class myIter implements Iterator{
        private int index;
        public myIter(){
            index = 0;
        }


        // make new list in ascending order

//        MyPriorityQueue<T> object = new MyPriorityQueue<>(comparator);
        Iterator<T> iter = queueItems.iterator();


        @Override
        public boolean hasNext() {
            return index < queueItems.size();
        }

        @Override
        public Object next() {
            index++;
            return queueItems.get(index-1);
        }
    }
}
