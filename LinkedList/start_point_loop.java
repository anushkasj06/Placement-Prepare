package LinkedList;

public class start_point_loop {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
        }
    }
    public static node startPoint(node head){
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null; // No cycle
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
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
        e.next = c; // Creating a cycle
        node start = startPoint(a);
        if(start != null){
            System.out.println("Start point of the loop: " + start.data);
        } else {
            System.out.println("No loop found.");
        }

    }
}
