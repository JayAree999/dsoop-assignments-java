import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeNode {
  public int key;
  public BinaryTreeNode left, right;
  
  public BinaryTreeNode(BinaryTreeNode left_,
                        int key_,
                        BinaryTreeNode right_) {
    this.left = left_;
    this.key = key_;
    this.right = right_;
  }
  
  public BinaryTreeNode(int key_) {
    this(null, key_, null);
  }




}
