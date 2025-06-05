import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Zigzag_traversal {
    public static class TreeNode {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currlevel = new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++){
                if(!reverse){
                    TreeNode currNode = queue.pollFirst();
                    currlevel.add(currNode.val);
                    if(currNode.left!=null){
                        queue.addLast(currNode.left);
                    }
                    if(currNode.right!=null){
                        queue.addLast(currNode.right);
                    }
                }else{
                    TreeNode currNode = queue.pollLast();
                    currlevel.add(currNode.val);
                    if(currNode.right!=null){
                        queue.addFirst(currNode.right);
                    }
                    if(currNode.left!=null){
                        queue.addFirst(currNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currlevel);
            
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Zigzag_traversal obj = new Zigzag_traversal();
        List<List<Integer>> result = obj.zigzagLevelOrder(root);
        System.out.println(result); 
    }
}
