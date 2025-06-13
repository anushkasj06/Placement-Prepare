package LinkedList;
import java.util.*;

public class middle_node {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
        }
    }
    public static node middle(node head){
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        node a = new node(1);
        node b = new node(2);
        node c = new node(3);
        node d = new node(4);
        node e = new node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        node mid = middle(a);
        System.out.println(mid.data);
    
    }
}
