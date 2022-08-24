import java.math.BigInteger;
//Collaborator =Nutchapol
public class Fib{
    public static BigInteger countDigit(BigInteger n ){
        BigInteger count= BigInteger.valueOf(0);
        BigInteger zero= BigInteger.valueOf(0);

        while (n != zero){
            n=n.divide(BigInteger.valueOf(10));
            count=count.add(BigInteger.valueOf(1));
        }
        return count;

    }

    public static int firstNDigit(int n){
        BigInteger first = BigInteger.valueOf(0);
        BigInteger second = BigInteger.valueOf(1);
        BigInteger third = BigInteger.valueOf(0);
        int counti=0;

        for (int i = 1;i<=40000;i++){

            first = second;
            second = third;
            third=(first.add(second));

            counti++;
            if (countDigit(third).equals(BigInteger.valueOf(n)) ){
                break;
            }

            }
        return counti;
        }

    public static void main(String[] args) {
        System.out.println(firstNDigit(2));


    }
    }
