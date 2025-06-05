import java.util.*;


public class Vertical_Traversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static class tuple{
        TreeNode node;
        int row;
        int col;
        tuple(TreeNode _node,int _row,int _col){
            node = _node;
            row= _row;
            col =_col;
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<tuple> q = new LinkedList<tuple>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.offer(new tuple(root,0,0));
        while(!q.isEmpty()){
            tuple tup = q.poll();
            TreeNode node = tup.node;
            int x = tup.row;
            int y = tup.col;

            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left!=null){
                q.offer(new tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offer(new tuple(node.right,x+1,y+1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> node : ys.values()){
                while(!node.isEmpty()){
                    System.out.println(node.peek());
                    list.get(list.size()-1).add(node.poll());
                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = verticalTraversal(root);
        System.out.println(result);
    }
}
