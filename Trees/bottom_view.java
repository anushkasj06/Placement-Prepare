import java.util.*;

public class bottom_view {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        int hd;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public static List<Integer> bottomView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        
        if (root == null) {
            return ans;
        }
        
        root.hd = 0;
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            int hd = temp.hd;
            map.put(hd, temp.data); // Overwrites previous node at same hd
            
            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(18);

        List<Integer> ans = bottomView(root);
        System.out.println(ans); // Expected bottom view
    }
}
