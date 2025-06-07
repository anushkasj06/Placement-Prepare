import javax.swing.tree.TreeNode;
import java.util.*;


public class Inorder_Preorder {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    Map<Integer, Integer> map = new HashMap<>();
    int idx=0;

    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        for(int i=0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        return build(preOrder,inOrder,0,inOrder.length-1);
    }

    private TreeNode build(int[] preOrder, int[] inOrder, int start, int end){
        if(start>end){
            return null;
        }
        int val = preOrder[idx++];
        TreeNode node = new TreeNode(val);
        int id = map.get(val);
        node.left = build(preOrder,inOrder,start,id-1);
        node.right = build(preOrder,inOrder,id+1,end);
        return node;
    }

    public static void main(String[] args) {
        Inorder_Preorder l = new Inorder_Preorder();
        int[] preOrder = {1,2,4,3,5};
        int[] inOrder = {4,2,1,5,3};
        TreeNode root = l.buildTree(preOrder,inOrder);
        System.out.println(root.val);
    }
    
}
