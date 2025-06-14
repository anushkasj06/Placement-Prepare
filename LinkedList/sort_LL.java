package LinkedList;

public class sort_LL {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }

    }

    public static node sortList(node head){
        if(head == null || head.next == null){
            return head;
        }
        node slow = head;
        node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        node mid = slow.next;
        slow.next = null;
        node left = sortList(head);
        node right = sortList(mid);
        return merge(left, right);
    }
    public static node merge(node left, node right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        node dummyhead = new node(0);
        node curr = dummyhead;
        while(left!=null && right!=null){
            if(left.data < right.data){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if(left!=null){
            curr.next = left;
        }
        if(right!=null){
            curr.next = right;
        }
        return dummyhead.next;
    }
    public static void main(String[] args) {
        node head = new node(4);
        head.next = new node(2);
        head.next.next = new node(1);
        head.next.next.next = new node(3);
        head = sortList(head);
    }
}
