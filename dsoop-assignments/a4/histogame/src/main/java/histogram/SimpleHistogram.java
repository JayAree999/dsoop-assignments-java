package histogram;



import java.util.*;

// TODO: Uncomment this and make sure to implement all the methods

public class SimpleHistogram<DT> implements Histogram<DT>, Iterable<DT> {

    public HashMap<DT, Integer> info= new HashMap<DT,Integer>();


    public SimpleHistogram(){

    }
    // constructs a histogram from a list of items given by the parameter items
    public SimpleHistogram(DT items[]){

        for (DT item : items){
            int count =1;

            if(info.containsKey(item)) {

                count = info.get(item);

                count++;

            }

            setCount(item,count);


        }
        System.out.println(info.values());


    }
    // constructs a (new) histogram from an existing histogram, sharing nothing
// internally
    public SimpleHistogram(Histogram hist){
        SimpleHistogram<DT> copy = new SimpleHistogram<DT>();
        Iterator<DT> itcopy = hist.iterator();


        while (itcopy.hasNext()) {
            DT T = itcopy.next();
            copy.setCount(T, hist.getCount(T));

        }
        System.out.println(copy.getTotalCount());



    }





    @Override
    public int getTotalCount() {
        int total =0;
        for (int i : info.values()){
            total+=i;


        }
        return total;
    }


    @Override
    public int getCount(DT item) {
        if(info.get(item) == null){
            return 0;
        }
        return info.get(item);
    }

    @Override
    public void setCount(DT item, int count) {
        info.put(item, count);

    }

    @Override
    public Iterator<DT> iterator() {

        return new myIterator();
    }
    @Override
    public String toString() {

        String res = "";
        res+=info;

        return res;
    }

    @Override
    public boolean equals(Object obj) {


        SimpleHistogram other3 = (SimpleHistogram) obj;
        System.out.println(other3.info);
        System.out.println(this.info);

        //check size
        if (other3.info.size()==this.info.size()){
            return true;
        }
        //check domains
        for (DT i : this.info.keySet()){
            if (other3.info.containsKey(i)){
                return true;
            }
        }
//        SimpleHistogram copy = SimpleHistogram
//        System.out.println(this.info);
//        if (info == null) {
//            if (other.info != null)
//                return false;
//        } else if (!info.equals(other.info))
//            return false;`
//        return true;
        return false;

    }
    //    public boolean isEquals(SimpleHistogram<DT> a, SimpleHistogram<DT> b){
//        System.out.println(a.getTotalCount());
//        System.out.println(a.getTotalCount());
//        System.out.println(b.getTotalCount());
//        System.out.println(b.getTotalCount());
//
//
//
//
//        return false;
//    }


    class myIterator implements Iterator<DT> {
        private int index;

        public myIterator() {

            index = 0;


        }

        @Override
        public boolean hasNext() {

            return index < info.size();
        }

        @Override
        public DT next() {

            ArrayList<DT> dt = new ArrayList<DT>();
            dt.addAll(info.keySet());



            DT toreturn = dt.get(index);
            index++;

            return toreturn;
        }





    }



}




