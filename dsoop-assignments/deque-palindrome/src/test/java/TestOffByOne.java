//IMPORTANT:
// * Uncomment this file after you have implemented OffByOne

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offByN = new OffByOne();

    @Test
    public void testOffByOne() {
        OffByOne obo = new OffByOne();
        obo.equalChars('a', 'b'); // ==> true
        obo.equalChars('r', 'q'); // ==> true
        obo.equalChars('a', 'e'); // ==> false
        obo.equalChars('z', 'a'); // ==> false
        obo.equalChars('a', 'a'); // ==> false

    }



    @Test

    public void testOffByN() {

        OffByN offBy5 = new OffByN(5);
        offBy5.equalChars('a', 'f'); // ==> true
        offBy5.equalChars('f', 'a'); // ==> true
        offBy5.equalChars('f', 'h'); // ==> false

        // Your tests go here.
    }


}
