package practice;
import java.security.KeyStore.Entry;
import java.util.*;

public class bottomView_Tree {
    class Node {
        int data;
        Node left, right;
        int hd; // horizontal distance from root

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public List<Integer> bottomView(Node root) {
        // Implementation for bottom view
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Map<Integer,Integer> map = new TreeMap<>();
        root.hd =0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            int hd = curr.hd;
            map.put(hd,curr.data);
            if(curr.left!=null){
                curr.left.hd = hd-1;
                q.add(curr.left);
            }
            if(curr.right!=null){
                curr.right.hd = hd+1;
                q.add(curr.right);
            }
        }

        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            result.add(m.getValue());
        }
        return result;

    }

    public static void main(String[] args) {
        bottomView_Tree tree = new bottomView_Tree();
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);
        root.right.right = tree.new Node(6);
        List<Integer> bottomView = tree.bottomView(root);
        System.out.println("Bottom view of the tree: " + bottomView);
    }
}
