
public class OffByN implements CharacterComparator{
    private int n;

    public OffByN(int N){
        n = N;

    }

    public boolean equalChars(char x, char y){
        if (Math.abs(Character.compare(x,y))==n) {
            return true;
        }
        else{
            return false;
        }
    }




}