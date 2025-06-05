import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class postorder_iterative {

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
        Stack<TreeNode> s2 = new Stack<>();
        if(root==null){
            return ans;
        }
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode curr = s1.peek();
            s1.pop();
            s2.push(curr);
            if(curr.left!=null){
                s1.push(curr.left);
            }
            if(curr.right!=null){
                s1.push(curr.right);
            }
        }
        while(!s2.isEmpty()){
            TreeNode p = s2.peek();
            s2.pop();
            ans.add(p.val);
        }
        return ans;
    }
}
