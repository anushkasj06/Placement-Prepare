
public class preorder_BST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }
    static int count = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        count = 0; // reset count before each call
        return bst(preorder, Integer.MAX_VALUE);
    }

    private static TreeNode bst(int[] a, int bound) {
        if (count == a.length || a[count] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(a[count]);
        count++;
        root.left = bst(a, root.val);
        root.right = bst(a, bound);
        return root;
    }
    public static void main(String[] args) {
        preorder_BST bst = new preorder_BST();
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bst.bstFromPreorder(preorder);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val); 
        System.out.println(root.left.left.val); 
        System.out.println(root.right.left.val); 
        System.out.println(root.right.right.val); 
        System.out.println(count);
    }
}
