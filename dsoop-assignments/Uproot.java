import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uproot {
    public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T){
        //create new map
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //go to helper
        return TPMhelper(T,map);
    }

    public static HashMap<Integer, Integer> TPMhelper(BinaryTreeNode T, HashMap<Integer, Integer> map){
        //Base case: if no T stop
        if(T == null){
            return null;
        }

        //if T.right exist, put in map in format <key,root>
        if(T.right != null){
            map.put(T.right.key,T.key);
        }
        //if T.left exist, put in map in format <key,root>
        if(T.left != null){
            map.put(T.left.key,T.key);
        }

        //go right
        TPMhelper(T.right,map);
        //go left
        TPMhelper(T.left,map);

        return map;
    }

    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map){
        Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        int root=map.keySet().iterator().next();
        while(map.containsKey(root))
        {
            root=map.get(root);
        }
        BinaryTreeNode node =new BinaryTreeNode(root);

        for(int k:map.keySet()){
            List<Integer> val=new ArrayList<>();
            if(m.containsKey(map.get(k)))
            {
                m.get(map.get(k)).add(k);
            }
            else
            {
                val.add(k);
                m.put(map.get(k),val);
            }
        }

        return buildnewNode(m,node,root);

    }
    public static BinaryTreeNode buildnewNode(Map<Integer, List<Integer>> map,BinaryTreeNode btn, int key)
    {
        List<Integer> list= map.get(key);
        if(map.get(key)==null){
            return btn;
        }
        if (map.get(key).size() == 2)
        {
            int left = map.get(key).get(0);
            int right = map.get(key).get(1);
            btn.left = new BinaryTreeNode(left);
            btn.right = new BinaryTreeNode(right);
            buildnewNode(map, btn.left,left);
            buildnewNode(map, btn.right,right);
        }
        else if(list.size()==1)
        {
            int left = map.get(key).get(0);
            btn.left = new BinaryTreeNode(map.get(key).get(0));
            buildnewNode(map, btn.left,left);
        }
        return btn;
    }
    public static void inOrder(BinaryTreeNode node) { // ceadit to fifa

        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf("%s ", node.key);
        inOrder(node.right);
    }
    public static void main(String[] args) {
        //Leaves
        BinaryTreeNode a = new BinaryTreeNode(1);
        BinaryTreeNode b = new BinaryTreeNode(20);
        BinaryTreeNode c = new BinaryTreeNode(9);
        //lv2
        BinaryTreeNode d = new BinaryTreeNode(a,14,null);
        BinaryTreeNode e = new BinaryTreeNode(b,2,c);
        //root
        BinaryTreeNode f = new BinaryTreeNode(d,8,e);

        System.out.println(treeToParentMap(f).toString());


        inOrder(parentMapToTree(treeToParentMap(f)));



    }



}