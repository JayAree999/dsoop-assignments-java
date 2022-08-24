import java.util.Arrays;

public class Zombies {

    public static int merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, count = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                arr[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            } else if (left[i] >= right[j]) {
                arr[i+j] = left[i];
                i++;
            } else {
                arr[i+j] = right[j];
                count += left.length-i;
                j++;
            }
        }
        return count;
    }

     public static int countBad(int[] hs) {
        if (hs.length < 2)
            return 0;

        int m = (hs.length + 1) / 2;
        int left[] = Arrays.copyOfRange(hs, 0, m);
        int right[] = Arrays.copyOfRange(hs, m, hs.length);

        return countBad(left) + countBad(right) + merge(hs, left, right);
    }


    public static void main(String[] args) {
        int[] arr =  new int[] {1, 7, 22, 13, 25, 4, 10, 34, 16, 28, 19, 31};
        System.out.println(countBad(arr));

    }
}