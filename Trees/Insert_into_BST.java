public class Insert_into_BST{
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

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        } else {
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

    public static Node insertinBST(Node root, int key){
        if(root == null){
            return new Node(key);
        }
        Node curr = root;
        Node prev = null;
        while(curr != null){
            if(curr.data == key){
                return root;
            }
            prev = curr;
            if(curr.data > key){
                curr = curr.left;
            } else{
                curr = curr.right;
            }
        }
        Node newNode = new Node(key);
        if(prev.data > key){
            prev.left = newNode;
        } else {
            prev.right = newNode;
            }
        return root;

    }


    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
        int key = 9;
        insertinBST(root, key);
    }

}