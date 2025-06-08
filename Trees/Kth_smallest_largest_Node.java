public class Kth_smallest_largest_Node{
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
    int count =0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result;
    }

    public void helper(TreeNode root, int k){
        if(root == null|| count>=k){
            return ;
        }

        helper(root.left, k);

        count++;

        if(count == k){
            result = root.val;
            return;
        }

        helper(root.right, k);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        Kth_smallest_largest_Node obj = new Kth_smallest_largest_Node();
        System.out.println(obj.kthSmallest(root, 1));
    }


}