import java.util.HashMap;
import java.util.*;

public class Inorder_postorder_BT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        postIndex = postorder.length -1;
        return helper(map,postorder,0,postIndex);
    }

    TreeNode helper(HashMap<Integer, Integer> map, int[] postorder, int left, int right){
        if(left>right){
            return null;
        }
        int val = postorder[postIndex--];
        TreeNode root = new TreeNode(val);
        int splitIndex = map.get(val);
        root.right = helper(map,postorder,splitIndex+1,right);
        root.left = helper(map,postorder,left,splitIndex-1);
        return root;
    }
    public static void main(String[] args) {
        Inorder_postorder_BT obj = new Inorder_postorder_BT();
        int[] inorder = {9,3,15,20,7};

        int[] postorder = {9,15,7,20,3};

        TreeNode root = obj.buildTree(inorder,postorder);
        System.out.println(root.val);
    }
}
