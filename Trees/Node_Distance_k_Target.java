import  java.util.*;

public  class Node_Distance_k_Target {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void mapparent(TreeNode root,HashMap<TreeNode,TreeNode> parent){
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        mapparent(root,parent);
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        int curr_level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (curr_level == k) {
                break;
            }
            curr_level++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && !visited.containsKey(curr.left)) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && !visited.containsKey(curr.right)) {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent.containsKey(curr) && !visited.containsKey(parent.get(curr))) {
                    q.add(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node_Distance_k_Target l = new Node_Distance_k_Target();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode target = new TreeNode(5);
        int k = 2;
        List<Integer> res = l.distanceK(root,target,k);
        System.out.println(res);
    }
}
