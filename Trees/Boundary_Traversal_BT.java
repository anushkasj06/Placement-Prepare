import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Boundary_Traversal_BT {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static List<Integer> boundaryTraversal(TreeNode node){
        List<Integer> ans = new ArrayList<>();
        if(isleaf(node) == false){
            ans.add(node.data);
        }
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }

    public static void addLeftBoundary(TreeNode node, List<Integer> ans){
        TreeNode curr = node.left;
        while(curr != null){
            if(isleaf(node)==false){
                ans.add(curr.data);
            }
            if(curr.left!=null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }

    public static void addRightBoundary(TreeNode node, List<Integer> ans){
        TreeNode curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr!=null) {
            if(isleaf(node)==false){
                temp.add(curr.data);
            }
            if(curr.right!=null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        int i;
        for(i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }

    public static void addLeaves(TreeNode node, List<Integer> ans){
        if(isleaf(node)){
            ans.add(node.data);
            return;
        }
        if(node.left!=null){
            addLeaves(node.left, ans);
        }
        if(node.right!=null){
            addLeaves(node.right, ans);
        }
    }


    public static boolean isleaf(TreeNode node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = boundaryTraversal(root);
        System.out.println(result);

    }
}
