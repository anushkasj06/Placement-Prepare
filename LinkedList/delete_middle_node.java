package LinkedList;

public class delete_middle_node {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public static node delete_middle(node head){
        if(head == null || head.next == null){
            return null;
        }
        node prev = null;
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        slow.next = null;
        return head;

        
    }
}
