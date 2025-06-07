public class Floor_Ceil_BST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }

    public static int findFloor(TreeNode root, int key){
        int floor = -1;
        while(root != null){
            if(root.val == key){
                return root.val;
            }
            if(root.val < key){
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }

    public static int findCeil(TreeNode root, int key){
        int ceil = -1;
        while(root != null){
            if(root.val == key){
                return root.val;
            }
            if(root.val > key){
                ceil = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int key = 2;
        int floor = findFloor(root, key);
        int ceil = findCeil(root, key);

        System.out.println("Floor of " + key + ": " + floor);
        System.out.println("Ceil of " + key + ": " + ceil);

        key = 5;
        floor = findFloor(root, key);
        ceil = findCeil(root, key);

        System.out.println("Floor of " + key + ": " + floor);
        System.out.println("Ceil of " + key + ": " + ceil);

    }
}
