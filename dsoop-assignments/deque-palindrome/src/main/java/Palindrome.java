
public class Palindrome extends LinkedListDeque implements Deque {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> a = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            a.addLast(word.charAt(i));
        }

        return a;

    }




    public boolean isPalindrome(String word) { // ignore middle
        boolean isPa = true;
        int length = word.length();
        Deque<Character> a = wordToDeque(word);
        for (int i = (length / 2)-1; i >=0 &&word.length()>1; i--) {
            if (!a.removeFirst().equals(a.removeLast())) {
                isPa = false;

            } else {
                isPa = true;
            }
        }

        return isPa;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) { // ignore middle
        boolean isPa = true;
        int length = word.length();
        Deque<Character> a = wordToDeque(word);
        for (int i = (length / 2)-1; i >=0 &&word.length()>1; i--) {
            if (!cc.equalChars(a.removeFirst(),(a.removeLast()))) {
                isPa = false;

            } else {
                isPa = true;
            }
        }

        return isPa;
    }




}

