package LinkedList;

public class add_1_number {
    public static class node{
        int data;
        node next;

        node(int data){
            this.data = data;
            this.next = null;
        }
        
    }

    public static node addone(node head){
        if(head == null){
            return new node(1);
        }
        int carry = helper(head);
        if(carry==1){
            node newnode = new node(1);
            newnode.next = head;
            return newnode;

        }
        return head;
    }

    public static int helper(node temp){
        if(temp == null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.data = temp.data + carry;
        if(temp.data<10){
            return 0;
        }
        temp.data = 0;
        return 1;
    }

    public static void main(String[] args) {
        node head = new node(9);
        head.next = new node(9);
        head.next.next = new node(9);
        head.next.next.next = new node(9);
        head.next.next.next.next = new node(9);

        head = addone(head);
        
    }
}
