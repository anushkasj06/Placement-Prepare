package LinkedList;

public class remove_nth_node_end {
    public static class node{
        int data;
        node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static node removeNthFromEnd(node head, int n){
        if(head == null || head.next == null){
            return null;
        }
        node temp = head;
        int count =0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        if(n == count){
            return head.next;
        }
        temp = head;
        for(int i=1;i<count-n;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;

        
    }

    public static void printList(node head){
        node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        node head = new node(1);
        head.next = new node(2);
        head.next.next = new node(3);
        head.next.next.next = new node(4);
        head.next.next.next.next = new node(5);

        System.out.println("Original List:");
        printList(head);

        int n = 2;
        head = removeNthFromEnd(head, n);

        System.out.println("List after removing " + n + "th node from end:");
        printList(head);

        head = new node(1);
        head.next = new node(2);
        n = 1;
        head = removeNthFromEnd(head, n);
        System.out.println("List after removing " + n + "th node from end:");
        printList(head);

        head = new node(1);
        n = 1;
        head = removeNthFromEnd(head, n);
        System.out.println("List after removing " + n + "th node from end:");
        
    }
}
