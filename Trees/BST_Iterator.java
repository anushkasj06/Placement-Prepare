import java.util.Stack;

public class BST_Iterator {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    private static Stack<TreeNode> s = new Stack<>();

    public static void BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public static int next() {
        TreeNode temp = s.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public static boolean hasNext() {
        return !s.isEmpty();
    }

    private static void pushAll(TreeNode node){
        while(node!=null){
            s.push(node);
            node = node.left;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator(root);
        System.out.println(next());
        System.out.println(next());
        System.out.println(hasNext());
        System.out.println(next());
        System.out.println(hasNext());  
    }
}
