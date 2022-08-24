import java.util.Arrays;
//Collaborators: Worawit and Lorenzo and Nutchapol
public class Subsel {
    public static int[] takeEvery(int[] a,int stride,int beginWith) {
        int count = 0;
        for (int s = 0;  beginWith + (s * stride) >=0 &&  beginWith + (s * stride) < a.length; s++){
            count++;
        }
        int[] newArray = new int[count];

        for (int s = 0;  beginWith + (s * stride) >=0 && beginWith + (s * stride) < a.length; s++) { // loop for the s to not out of bound -> a[b+s*0,s*1,s*2,...]
            newArray[s] = a[beginWith+s*stride];
        }
        return newArray;



    }
    public static int[] takeEvery(int[] a,int stride){

        return takeEvery(a,stride,0); // the default value when beginWith is not given.
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString( takeEvery(new int[] {3,1,4,5,9,2,6,5},-1,5)));

    }
}
