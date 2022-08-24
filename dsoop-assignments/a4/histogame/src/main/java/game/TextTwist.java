package game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TextTwist {
    private static final int MIN_WORD_LENGTH = 3;

    private static final int MAX_WORD_LENGTH = 6;

    private static final int WORDS_PER_ROW = 5;

    private WordDatabase db;

    private Random random;

    private Word currentWord;

    private String currentWordToDisplay;

    private List<Word> subWords;

    private boolean[] guessed;

    private long startTime;

    private int score;

    private int maxScore;

    public TextTwist(String filename) throws IOException {
        this.db = new WordDatabase(filename);
        this.random = new Random();
    }

    private String shuffle(String input) {
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray())
            characters.add(Character.valueOf(c));
        StringBuilder output = new StringBuilder(input.length());
        while (characters.size() != 0) {
            int randPicker = this.random.nextInt(characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    public void newGame() {
        List<Word> words = this.db.getWordWithLength(6);
        int idx = this.random.nextInt(words.size());
        this.currentWord = words.get(idx);
        this.currentWordToDisplay = shuffle(this.currentWord.getWord());
        this.subWords = this.db.getAllSubWords(this.currentWord, 3);
        Collections.sort(this.subWords);
        this.guessed = new boolean[this.subWords.size()];
        this.score = 0;
        this.maxScore = this.subWords.size();
        this.startTime = System.currentTimeMillis();
    }

    public void guess(String word) {
        int i = 0;
        for (Word w : this.subWords) {
            if (w.getWord().equals(word)) {
                this.guessed[i] = true;
                this.score++;
                return;
            }
            i++;
        }
    }

    public void printStatus() {
        int counter = 0;
        for (int i = 0; i < this.subWords.size(); i++) {
            if (!this.guessed[i]) {
                for (int j = 0; j < ((Word)this.subWords.get(i)).getWord().length(); ) {
                    System.out.print("?");
                    j++;
                }
                System.out.print(" ");
            } else {
                System.out.print(((Word)this.subWords.get(i)).getWord() + " ");
            }
            counter++;
            if (counter % 5 == 0)
                System.out.println();
        }
        System.out.println("\n");
    }

    public void printPrompt() {
        long millis = System.currentTimeMillis() - this.startTime;
        System.out.printf("Elapsed Time: %.2f seconds, Score: %d/%d\n", new Object[] { Double.valueOf(millis / 1000.0D), Integer.valueOf(this.score), Integer.valueOf(this.maxScore) });
        System.out.println("Commands: q - quit, ! - give up, ? - info");
        System.out.print("[" + this.currentWordToDisplay + "] > ");
    }

    public void reveal() {
        for (int i = 0; i < this.subWords.size(); i++)
            this.guessed[i] = true;
    }

    public void runGame() {
        newGame();
        Scanner sc = new Scanner(System.in);
        while (true) {
            printPrompt();
            String command = sc.next().toLowerCase();
            if (command.charAt(0) == '!') {
                reveal();
                printStatus();
                newGame();
                continue;
            }
            if (command.charAt(0) == '?') {
                printStatus();
                continue;
            }
            if (command.equals("q")) {
                System.out.println("Bye!");
                System.exit(0);
                continue;
            }
            guess(command);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            TextTwist tt = new TextTwist("linuxwords.txt");
            tt.runGame();
        } catch (FileNotFoundException e) {
            System.out.println("DB fail");
        }
    }
}
