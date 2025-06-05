import java.util.*;

public class root_to_node_path{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static boolean helper(Node root,ArrayList<Integer> path,int x){
        if(root == null){
            return false;
        }
        path.add(root.data);
        if(root.data == x){
            return true;
        }
        if(helper(root.left,path,x) || helper(root.right,path,x)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    private static List<Integer> findpath(Node root,int x){
        ArrayList<Integer> path = new ArrayList<>();
        if(root == null){
            return path;
        }
        helper(root,path,x);
        return path;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        List<Integer> path = findpath(root,9);
        System.out.println(path);
    }
}