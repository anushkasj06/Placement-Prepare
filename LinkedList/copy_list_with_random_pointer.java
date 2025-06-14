package LinkedList;

public class copy_list_with_random_pointer {
    public static class Node{
        int val;
        Node next;
        Node random;
        Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public static Node copyRandomList(Node head) {
        Node curr = head;
        while(curr!=null){
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        curr = head;
        while(curr!=null){
            if(curr.next != null){
                curr.next.random = (curr.random != null) ? curr.random.next : null;
            }
            curr = curr.next.next;
        }

        Node dummy = new Node(-1);
        Node res = dummy;
        Node temp = head;
        while(temp != null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next.next.next;

        Node copyhead = copyRandomList(head);

    }
}
