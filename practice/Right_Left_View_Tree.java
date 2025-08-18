package practice;

import java.util.*;
import java.util.List;
import java.util.Queue;

public class Right_Left_View_Tree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public List<Integer> rightView(Node root) {
        // Implementation for right view
        Queue<Node> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelsize = q.size();
            for(int i=0;i<levelsize;i++){
                Node curr = q.poll();
                if(i==levelsize-1){
                    list.add(curr.data);
                }
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return list;
    }

    public List<Integer> leftView(Node root) {
        // Implementation for left view
        Queue<Node> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelsize = q.size();
            for(int i=0;i<levelsize;i++){
                Node curr = q.poll();
                if(i==0){
                    list.add(curr.data);
                }
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return list;
    }
}
