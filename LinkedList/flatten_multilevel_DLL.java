package LinkedList;

public class flatten_multilevel_DLL{
    public static class Node{
        int val;
        Node prev;
        Node next;
        Node child;
        Node(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }

    }
    public Node flatten(Node head) {
        Node curr = head;
        while(curr != null){
            if(curr.child != null){
                Node tail = findtail(curr.child);
                if(curr.next != null){
                    curr.next.prev = tail;
                }
                tail.next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }

    public Node findtail(Node child){
        while(child.next != null){
            child = child.next;
        }
        return child;
    }
}