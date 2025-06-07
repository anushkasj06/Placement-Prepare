public class Min_Max_BST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public static TreeNode findMin(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static TreeNode findMax(TreeNode root){
        if(root==null){
            return null;
        }   
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(8);
        TreeNode min=findMin(root);
        TreeNode max=findMax(root);
        System.out.println("Min: "+min.val);
        System.out.println("Max: "+max.val);

    }

}
