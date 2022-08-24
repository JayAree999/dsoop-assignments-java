import java.util.Arrays;
//Collaborator : Worawit and Nutchapol
public class Happy{
    public static long sumOfDigitsSquared(long n){
        long sum=0;
        while (n>0){
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;

    }
    public static boolean isHappy(long n) {
        boolean f=false;
        long sum=0;
        while (n>0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        while (sum != 1 && sum!=4 ){
            sum=sumOfDigitsSquared(sum);
        }
        if (sum == 1){
            f=true;
        }
        return f;




    }
    public static long[] firstK(int k){
        int i = 0; // index
        int n=1; //number

        long[] newArray = new long[k];
        while (i < k) {
            if (isHappy(n)) {
                newArray[i]=n;
                n++;
                i++;
            }
            else{
                n++;


                }

            }
        return newArray;

        }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(firstK(9)));
    }


}


