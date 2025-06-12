package LinkedList;

public class oddevenlist {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static node oddeven(node head){
        if (head == null || head.next == null){
            return head;
        }
        node odd = head;
        node even = head.next;
        node evenhead = even;
        while (even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
    public static void main(String[] args) {
        node head = new node(1);
        head.next = new node(2);
        head.next.next = new node(3);
        head.next.next.next = new node(4);
        head.next.next.next.next = new node(5);
        node res = oddeven(head);
        while (res!=null){
            System.out.print(res.data+" ");
            res = res.next;
        }
    }
}
