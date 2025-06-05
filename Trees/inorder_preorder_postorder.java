import java.util.*;

public class inorder_preorder_postorder {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int _val){
            val = _val;
        }
    }
    public static class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode _node, int _num){
            node = _node;
            num = _num;
        }

    }
    public void preInPostTraversal(TreeNode root){
        Stack<Pair>  st = new Stack<>();
        st.push(new Pair(root,1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        while(!st.isEmpty()){
            Pair it = st.pop();

            //this is part of pre 
            //incremnet 1 to 2
            //oush the left side of the tree
            if(it.num ==1){
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.left !=null){
                    st.push(new Pair(it.node.left,1));
                }
            }

            //this is part of the in
            //increamnet 2 to 3 
            //push right
            else if(it.num ==2){
                in.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.right !=null){
                    st.push(new Pair(it.node.right,1));
                }
            }

            //dont push it back it back again;
            else{
                post.add(it.node.val);
            }
        }

        System.out.println("Preorder Traversal: " + pre);
        System.out.println("Inorder Traversal: " + in);
        System.out.println("Postorder Traversal: " + post);
        System.out.println("");

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        inorder_preorder_postorder obj = new inorder_preorder_postorder();
        obj.preInPostTraversal(root);

    }
}
