package game;

import histogram.Histogram;
import histogram.SimpleHistogram;

import java.io.*;
import java.util.*;


public class Word implements Formable<Word>, Comparable<Word> {
    // The only constructor of the class, which takes a String representation
// of the word. The histogram is generated here from the given word.
    private String path;
//    InputStream is = getClass().getClassLoader().getResourceAsStream(path);
//    FileReader fileReader = new FileReader(path);
//    private WordDatabase db = new WordDatabase(path);


    private String wordexe;

    Histogram<Character> hist = new SimpleHistogram<>();


    public Word(String word) {
        wordexe = word;
        Character[] cList = new Character[word.length()];
        for (int i = 0; i<wordexe.length();i++){
            cList[i] = Character.valueOf(word.charAt(i));
        }
        hist = new SimpleHistogram<>(cList);

    }

    // Returns the String representation of the word.
    public String getWord() {
        return wordexe;

    }

    // Returns a Histogram describing the character distribution of the word.
    public Histogram<Character> getHistogram() {
//        WordDatabase check = new WordDatabase();


        return hist;

    }


    @Override
    public boolean canForm(Word other) {

       for(Character ch : other.hist){
            if(this.hist.getCount(ch) < other.hist.getCount(ch))
                return false;
        }
        return true;
    }

    @Override
    public int compareTo(Word o) {



        for (int i = 0; i < wordexe.length();i++) {

            if (wordexe.length() < o.getWord().length()) {
                return -1;
            }
            //Or == and < alphabetically to word
            else if (wordexe.length() == o.getWord().length() && wordexe.charAt(i) < o.getWord().charAt(i)) {
                return -1;

            } else if (wordexe.equals(o.getWord())) {
                return 0;
            }
            else {
                return +1;
            }
        }

        // compare 2 lists
        // if list1 is alphatbateically different from list2 then return -1

//        for (String w : wordexe.toString())

//        for (ine i )
//        for(int j=0;j<list2.length();j++){
//            if(buttonresourceIds.contains(buttonresourceIds2.get(j))){
//                System.out.println("Exist : "+buttonresourceIds2.get(j));
//                common++;
//            }else{
//                System.out.println("Not Exist : "+buttonresourceIds2.get(j));
//            }
//        }


//        if (wordexe.length() <= o.toString().length()) {
//            if (wordexe )
//            return -1;
//        }
//    }
        return -1;

    }


}
