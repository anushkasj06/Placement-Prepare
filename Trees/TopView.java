import java.util.*;

public class TopView {
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static class pair{
        TreeNode node;
        int hd;
        pair(TreeNode node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<pair> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        q.add(new pair(root, 0));
        while(!q.isEmpty()){
            pair it = q.remove();
            TreeNode temp = it.node;
            int hd = it.hd;
            if(!map.containsKey(hd)){
                map.put(hd, temp.data);
            }
            if(temp.left != null){
                q.add(new pair(temp.left, hd-1));
            }
            if(temp.right != null){
                q.add(new pair(temp.right, hd+1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        TopView obj = new TopView();
        TreeNode root = obj.new TreeNode(1);
        root.left = obj.new TreeNode(2);
        root.right = obj.new TreeNode(3);
        root.left.left = obj.new TreeNode(4);
        root.left.right = obj.new TreeNode(5);
        root.right.left = obj.new TreeNode(6);
        root.right.right = obj.new TreeNode(7);
        List<Integer> ans = obj.topView(root);
        for(int i : ans){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
