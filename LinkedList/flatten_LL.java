package LinkedList;

public class flatten_LL {
    public static class node{
        int data;
        node next;
        node child;

        node(int data){
            this.data = data;
            this.next = null;
            this.child= null;
        }

    }
    public static node flatten(node head){
        if(head == null || head.next == null){
            return head;
        }

        node mergehead = flatten(head.next);
        head = merge(head, mergehead);
        return head;
    }
    public static node merge(node head1, node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        node dummyhead = new node(-1);
        node temp = dummyhead;
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                temp.child = head1;
                temp = temp.child;
                head1 = head1.child;
            }
            else{
                temp.child = head2;
                temp = temp.child;
                head2 = head2.child;    
            }
            temp.next = null;
        }
        if(head1 != null){
            temp.child = head1;
        }
        if(head2 != null){
            temp.child = head2;
        }
        if(dummyhead.child != null){
            dummyhead.child.next = null;
        }
        return dummyhead.child;


    }

    public static void main(String[] args) {
        node head = new node(5);
        head.child = new node(7);
        head.child.next = new node(8);
        head.child.next.next = new node(30);
        head.next = new node(10);
        head.next.next = new node(19);
        head.next.next.next = new node(28);
        head.next.next.next.next = new node(80);
        head = flatten(head);

    }


}
