import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RightSide_view {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        RightSide_view obj = new RightSide_view();
        List<Integer> result = obj.rightSideView(root);
        System.out.println(result);
        
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return result;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode currNode = queue.poll();
                if(i==levelSize-1){
                    result.add(currNode.val);
                }

                if(currNode.left!=null){
                    queue.offer(currNode.left);
                }

                if(currNode.right!=null){
                    queue.offer(currNode.right);
                }
            }
        }

        return result;
    }
}
