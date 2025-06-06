import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width_BT {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){

        }
        TreeNode(int val){
            this.val = val;
        }
    }

    class pair<k,v>{
        private k key;
        private v value;

        public pair(k key, v value){
            this.key = key;
            this.value = value;
        }

        public k getKey(){
            return key;
        }

        public v getValue(){
            return value;
        }

    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new pair<>(root, 1));
        while(!q.isEmpty()){
            int n = q.size();
            int start =0, end =0;
            for(int i=0; i<n; i++){
                pair<TreeNode, Integer> p = q.poll();
                if(i==0) start = p.getValue();
                if(i==n-1) end = p.getValue();
                if(p.getKey().left != null){
                    q.offer(new pair<>(p.getKey().left, (p.getValue()-1) * 2 +1));
                }
                if(p.getKey().right != null){
                    q.offer(new pair<>(p.getKey().right, (p.getValue()-1) * 2 +2));
                }
            }
            ans = Math.max(ans, end - start +1);
        }

        return ans;

    }

    public static void main(String[] args) {
        Maximum_Width_BT obj = new Maximum_Width_BT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        System.out.println(obj.widthOfBinaryTree(root));
    }
}
