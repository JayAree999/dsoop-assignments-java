package game;

import histogram.Histogram;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// HINT(s):
//   To read from src/resources/<filename>
//   InputStream is = getClass().getClassLoader().getResourceAsStream(filename);

public class WordDatabase implements IDatabase {



//    private WordDatabase db  = new WordDatabase(path)
//    ;
    private List<Word> db;
    String filename = "linuxwords.txt";


    InputStream is= getClass().getClassLoader().getResourceAsStream("linux.txt");
    BufferedReader reader;

    public WordDatabase(String filename) throws FileNotFoundException,IOException{
        InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
        this.db= new ArrayList<Word>();
        this.reader = new BufferedReader(new InputStreamReader(is));


        while (reader.ready()) {
            String line = this.reader.readLine();
            db.add(new Word(line));

        }
    }
    @Override
    public void add(Word w) {
        db.add(w);

    }

    @Override
    public void remove(Word w) {
        db.remove(w);
    }

    @Override
    public List<Word> getWordWithLength(int l){
        List<Word> ret = new ArrayList<>();
        for (Word word : this.db) {
            if (word.getWord().length() == l)
                ret.add(word);
        }
        return ret;
    }

    @Override
    public List<Word> getAllSubWords(Word w, int minLen) {
        List<Word> ret = new ArrayList<>();
        for (Word word : this.db) {
            if (word.getWord().length() >= minLen && w.canForm(word))
                ret.add(word);
        }
        return ret;
    }

    @Override
    public boolean contains(Word o) {

        return this.db.contains(o);
    }
}
