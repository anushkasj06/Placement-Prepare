public class Successor_Predecer {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode inorderSuccesor(TreeNode root, int key) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > key) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    TreeNode inorderPredecessor(TreeNode root, int key) {
        TreeNode res = null;
        while (root != null) {
            if (root.val < key) {
                res = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Successor_Predecer sp = new Successor_Predecer();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
                root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.right = new TreeNode(25);            
        int key = 4;
        TreeNode inorderSuccesor = sp.inorderSuccesor(root, key);
        TreeNode inorderPredecessor = sp.inorderPredecessor(root, key);

    }

}
