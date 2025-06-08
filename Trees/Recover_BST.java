import javax.swing.tree.TreeNode;

public class Recover_BST {

     TreeNode prev, first,mid,last;
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
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val> root.val){
            if(first==null){
                first = prev;
                mid = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = mid = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }else if(first!=null && mid!=null){
            int t = first.val;
            first.val = mid.val;
            mid.val =t;
        }
        
    }
    public static void main(String[] args) {
        Recover_BST recover_bst = new Recover_BST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        recover_bst.recoverTree(root);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.left.right.val);
    }
}
