import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorder_stack {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        if(root==null){
            return ans;
        }
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode curr = s1.peek();
            s1.pop();
            ans.add(curr.val);
            if(curr.right!=null){
                s1.push(curr.right);
            }
            if(curr.left!=null){
                s1.push(curr.left);
            }
            
        }
        return ans;
    }
}
