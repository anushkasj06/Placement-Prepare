import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorder_stack {
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
        TreeNode curr = root;
        while(!s1.isEmpty() || curr!=null){
            if(curr!=null){
                s1.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode node = s1.peek();
                s1.pop();
                ans.add(node.val);
                curr = curr.right;

            }

        }
        return ans;
    }
}
