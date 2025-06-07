import java.util.*;

public class Time_to_Burn_BT {
   public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode mapparent(TreeNode root,HashMap<TreeNode,TreeNode> parent,int start){
        if(root==null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode res = null;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val==start){
                res = curr;
            }
            if(curr.left!=null){
                parent.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        return res;
    }

    public static int findMaxDistance(HashMap<TreeNode,TreeNode> parent,TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        q.add(target);
        visited.put(target,true);
        int maxi = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int flag = 0;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && !visited.containsKey(curr.left)){
                    q.add(curr.left);
                    visited.put(curr.left,true);
                    flag = 1;
                }
                if(curr.right!=null && !visited.containsKey(curr.right)){
                    q.add(curr.right);
                    visited.put(curr.right,true);
                    flag = 1;
                }   
                if(parent.containsKey(curr) && !visited.containsKey(parent.get(curr))){
                    q.add(parent.get(curr));
                    visited.put(parent.get(curr),true);
                    flag = 1;
                }
            }
            if(flag==1){
                maxi++; 
            }
        }
        return maxi;
    }


    public static int tinetoburn(TreeNode root,int start){
        if(root==null){
            return 0;
        }
        if(root.val==start){
            return 1;
        }
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        TreeNode target = mapparent(root,parent,start);
        int maxi = findMaxDistance(parent, target);
        return maxi;
    }

    public static void main(String[] args) {
        Time_to_Burn_BT l = new Time_to_Burn_BT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        int start = 5;
        int res = l.tinetoburn(root,start);

        System.out.println(res);
    }
 
}
