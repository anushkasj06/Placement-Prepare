public class Same_BST {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Same_BST bst = new Same_BST();
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println(bst.isSameTree(p, q));
        System.out.println(bst.isSameTree(null, null));
    }
}
