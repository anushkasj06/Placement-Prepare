package LinkedList;

public class rotate_LL_byK {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;
        }

    }


    public static node rotatebyk(node head,int k){
        if(k<=0 || head==null||head.next==null){
            return head;
        }
        node curr = head;
        int length =1;
        while(curr.next!=null){
            curr = curr.next;
            length++;
        }
        curr.next = head;
        int rotate = k%length;
        int skip = length-rotate;
        curr = head;
        for(int i=0;i<skip-1;i++){
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;

    }
    public static void main(String[] args) {
        node head = new node(10);
        head.next = new node(20);
        head.next.next = new node(30);
        head.next.next.next = new node(40);
        head.next.next.next.next = new node(50);
        head.next.next.next.next.next = new node(60);
        head.next.next.next.next.next.next = new node(70);
        head.next.next.next.next.next.next.next = new node(80);
        head.next.next.next.next.next.next.next.next = new node(90);
        head.next.next.next.next.next.next.next.next.next = new node(100);
        head.next.next.next.next.next.next.next.next.next.next = new node(110);

        head = rotatebyk(head, 4);
    }
}
