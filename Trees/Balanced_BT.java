import javax.swing.tree.TreeNode;

public class Balanced_BT {
    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        return Math.abs(height(root.right)- height(root.left))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode root){
        if(root==null){
            return 1;
        }

        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left,right)+1;
    }

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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(root));
    }
}
