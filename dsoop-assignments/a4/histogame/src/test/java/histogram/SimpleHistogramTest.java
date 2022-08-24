package histogram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;


//TODO: Uncomment me when you're done implementing the class
public class SimpleHistogramTest {


    @Test
    public void testHistogram() {
        Character[] target = {'a','b','c','a'};
        Histogram<Character> h = new SimpleHistogram<>(target);
//        System.out.println("H" + h.iterator());
        Iterator<Character> iter = h.iterator();
        int elemCount = 0;
//




        while(iter.hasNext()) {
            iter.next();
            elemCount++;
        }
        SimpleHistogram<Character> nh= new SimpleHistogram<Character>(h);

        //creating more test when things are internally equal ;or, the other historgram contain same domains and values.

        Character[] target2 = {'a','b','c','a'};
        Histogram<Character> h2 = new SimpleHistogram<>(target2);
        Iterator<Character> iter2 = h2.iterator();

        System.out.println(h.equals(h2));


        assertEquals(3, elemCount);
        assertEquals(2, h.getCount('a'));
        assertEquals(1, h.getCount('b'));
        assertEquals(1, h.getCount('c'));
        assertEquals(4, h.getTotalCount());
    }
}

