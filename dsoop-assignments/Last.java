public class Last {
    public static Integer binarySearchLast(int[] a, int k){
        int left = 0;
        int right = a.length - 1;

        // initialize the result by -1
        int result = -1;

        // loop till the search space is exhausted
        while (left <= right)
        {
            // find the mid-value in the search space and compares it with the target
            int mid = (left + right) / 2;

            // if the key is located, update the result and
            // search towards the right (higher indices)
            if (k == a[mid])
            {
                result = mid;
                left = mid + 1;
            }

            // if the key is less than the middle element, discard the right half
            else if (k < a[mid]) {
                right = mid - 1;
            }

            // if the key is more than the middle element, discard the left half
            else {
                left = mid + 1;
            }
        }
        if (result==-1){
            return null;
        }

        // return the leftmost index, or -1 if the element is not found
        return result;

    }

    public static void main(String[] args) {
        System.out.println(binarySearchLast(new int[]{1, 2, 2, 2, 4, 5}, 5));
        System.out.println(binarySearchLast(new int[]{1, 2, 2, 2, 4, 5}, 2));
        System.out.println(binarySearchLast(new int[]{1, 2, 2, 2, 4, 5}, 0));
    }
}
