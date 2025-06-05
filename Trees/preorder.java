import java.util.ArrayList;
import java.util.List;

public class preorder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
           this.right = right;
       }
    }
      public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> list = new ArrayList<>();
          preorder(root,list);
          return list;
      }
  
      private static void preorder(TreeNode root, List<Integer> list){
          if(root == null){
              return;
          }
          preorder(root.left,list);
          preorder(root.right,list);
          list.add(root.val);   
      } 
}
