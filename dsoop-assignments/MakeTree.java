public class MakeTree {
    public static BinaryTreeNode helper(int[] keys, int low, int high){
        // base case
        if (low > high) {
            return null;
        }

        // find the middle element of the current range
        int mid = (low + high) / 2;

        // construct a new node from the middle element and assign it to the root
        BinaryTreeNode a = new BinaryTreeNode(keys[mid]);

        // left subtree of the root will be formed by keys less than middle element
        a.left = helper(keys, low, mid - 1);

        // right subtree of the root will be formed by keys more than the
        // middle element
        a.right = helper(keys, mid + 1, high);

        return a;
    }

    //ans
    public static BinaryTreeNode buildBST(int[] keys){
        return helper(keys,0, keys.length -1);

    }

}
