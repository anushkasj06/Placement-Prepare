import java.util.*;

public class Largest_BST{
    public class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    
    public class NodeValue{
        public int maxNode, minNode, maxSize;
        NodeValue(int minNode, int maxNode, int maxSize){
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }

    }

    private  NodeValue isBST(Node root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeValue left = isBST(root.left);
        NodeValue right = isBST(root.right);

        if(left.maxNode < root.data && right.minNode > root.data){
            return new NodeValue(Math.min(left.minNode, root.data), Math.max(right.maxNode, root.data), left.maxSize + right.maxSize+1);                               
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));

    }

    public int largestBST(Node root){
        return isBST(root).maxSize;
    }

    public static void main(String[] args) {
        Largest_BST bst = new Largest_BST();
        Node root = bst.new Node(50);
        root.left = bst.new Node(30);
        root.right = bst.new Node(60);
        root.left.left = bst.new Node(5);
        root.left.right = bst.new Node(20);
        root.right.left = bst.new Node(55);
        root.right.left.left = bst.new Node(45);
        root.right.right = bst.new Node(70);
        root.right.right.left = bst.new Node(65);
        root.right.right.right = bst.new Node(80);
        System.out.println(bst.largestBST(root));
    }
}