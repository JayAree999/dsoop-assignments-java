
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.List;

public class Decor {

    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static int index;
/// main function

    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder) {
        // Store indexes of all items so that we
        // we can quickly find later
        for (int i = 0; i < inOrder.size(); i++) { //size in-o len
            map.put(inOrder.get(i), i);
        }
        index = inOrder.size() - 1;// Index in postorder

        return RecrHelp(inOrder, postOrder, 0, inOrder.size() - 1);
    }

    //Helper

    public static BinaryTreeNode RecrHelp(List<Integer> inOrder, List<Integer> postOrder, int start, int end) {

        if (start > end)
            return null;

/* Pick current node from Postorder traversal
    using postIndex and decrement postIndex */

        int root = postOrder.get(index);
        BinaryTreeNode node = new BinaryTreeNode(root);
        index--;
        /* If this node has no children then return */
        if (start == end)
            return node;
/* Else find the index of this node in Inorder
    traversal */
        int IndexIn = map.get(root);
  /* Using index in Inorder traversal, con
    left and right subtress */
        node.right = RecrHelp(inOrder, postOrder, IndexIn + 1, end);

        node.left = RecrHelp(inOrder, postOrder, start, IndexIn - 1);

        return node;

    }
    /* This funtcion is here just to test */
    static void preOrder(BinaryTreeNode node)
    {
        if (node == null)
            return;
        System.out.printf("%d ", node.key);
        preOrder(node.left);
        preOrder(node.right);
    }
    //test
    public static void main(String[] args)
    {
        List<Integer> post = new ArrayList<>();
        post.add(4);
        post.add(5);
        post.add(2);
        post.add(3);
        post.add(1);


        List<Integer> in = new ArrayList<>();
        in.add(4);
        in.add(2);
        in.add(5);
        in.add(1);
        in.add(3);

        int n = in.size()-1;

        System.out.print("Preorder of the constructed tree : \n");
        preOrder(mkTree(post, in));
    }
}
