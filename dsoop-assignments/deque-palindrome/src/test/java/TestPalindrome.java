
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        boolean d = palindrome.isPalindrome("");
        assertEquals(true, d);


    }

    @Test

    public void testisPalindrome2() {
        CharacterComparator c1 = new OffByN(1);
        boolean d = palindrome.isPalindrome("ef",c1);
        assertEquals(true, d);


    }







}
