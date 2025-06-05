import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LeftSide_View {
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

        LeftSide_View obj = new LeftSide_View();
        List<Integer> result = obj.leftSideView(root);
        System.out.println(result);
        
    }

    public List<Integer> leftSideView(TreeNode root) {
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
                if(i==0){
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
