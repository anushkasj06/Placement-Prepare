import java.util.*;


public class postorder {
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
      public List<Integer> postorderTraversal(TreeNode root) {
          List<Integer> list = new ArrayList<>();
          postorder(root,list);
          return list;
      }
  
      private static void postorder(TreeNode root, List<Integer> list){
          if(root == null){
              return;
          }
          postorder(root.left,list);
          postorder(root.right,list);
          list.add(root.val);   
      }
}
