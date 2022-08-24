import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MultiwayMerge {


    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists){
        PriorityQueue<LinkedList<Integer>> pq
                = new PriorityQueue<>(new Comparator<LinkedList<Integer>>() {
            @Override
            public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
                return o1.getFirst()-o2.getFirst();
            }
        });


        // push the head nodes of all
        // the k lists in 'pq'
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }

        LinkedList<Integer> res = new LinkedList<>( );
        // loop till 'pq' is not empty
        while (!pq.isEmpty()) {
            LinkedList<Integer> res2 = pq.poll();

            // get the top element of 'pq'
            res.add(res2.poll());
            if (!res2.isEmpty())
                pq.add(res2);

            // check if there is a node
            // next to the 'top' node

            }
        return res;

        }









}
