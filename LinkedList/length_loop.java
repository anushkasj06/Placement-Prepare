package LinkedList;

public class length_loop {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static int lengthofloop(node head){
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return findlength(slow, fast);
            }
        }
        return 0;        
    }
    public static int findlength(node slow, node fast){
        int count = 1;
        slow = slow.next;
        while(slow != fast){
            count++;
            slow = slow.next;
        }
        return count;
    }
    public static void display(node head){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
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
        System.out.println(lengthofloop(a));
        display(a);

    }
}
