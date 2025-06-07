import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


public class TwoSum_in_BST {
    static class Node{
        int data;
        Node left;
        Node right;


        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }


    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    HashSet<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();

    public void traversal(Node root){
        if(root == null){
            return;
        }
        traversal(root.left);
        list.add(root.data);
        set.add(root.data);
        traversal(root.right);
    }
    public  boolean twosum(Node root, int k){
        if(root == null){
            return false;
        }
        traversal(root);
        for(int i=0; i<list.size(); i++){
            if(set.contains(k-list.get(i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;


        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        int k = 9;
        TwoSum_in_BST obj = new TwoSum_in_BST();
        boolean found = obj.twosum(root, k);
        System.out.println(found);

    }

}
