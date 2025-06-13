package LinkedList;

public class hasCycle {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
        }
    }
    public static boolean hasCycle(node head){
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
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
        System.out.println(hasCycle(a));
    

    }
}
