

public class OffByOne implements CharacterComparator{


    public boolean equalChars(char x, char y) {
        if(Math.abs(Character.compare(x, y)) == 1){
            return true;
        }
        else {
            return false;
        }

    }

}