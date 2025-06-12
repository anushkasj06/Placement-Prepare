package LinkedList;

public class sort_0_1_2_list {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static node sort(node head){
        if (head == null || head.next == null){
            return head;
        }
        node zerohead = new node(-1);
        node onehead = new node(-1);
        node twohead = new node(-1);
        node zero = zerohead;
        node one = onehead;
        node two = twohead;
        node curr = head;
        while (curr!=null){
            if (curr.data == 0){
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1){
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = (onehead.next!=null)?onehead.next:twohead.next;
        one.next = twohead.next;
        two.next = null;
        return zerohead.next;
    }
    public static void main(String[] args) {
        node head = new node(1);
        head.next = new node(0);
        head.next.next = new node(2);
        head.next.next.next = new node(1);
        head.next.next.next.next = new node(0);
        node res = sort(head);
        while (res!=null){
            System.out.print(res.data+" ");
            res = res.next;
        }
        System.out.println();
    }
}
