package LinkedList;

public class Delete_all_occurance_k_DLL{
    public static class node{
        int data;
        node next;
        node prev;
        node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }

    }

    public static node deletealloccurance(node head, int k){
        if(head==null){
            return null;
        }

        node temp = head;
        while(temp!=null){
            if(temp.data==k){
                if(temp == head){
                    head = head.next;
                    head.prev=null;
                }

                node prev = temp.prev;
                node next = temp.next;
                temp.next=null;
                temp.prev=null;
                if(prev!=null){
                    prev.next=next;
                }
                if(next!=null){
                    next.prev=prev;
                }
                temp = next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    
    }

    public static void main(String[] args) {
        node head = new node(10);
        node temp = head;
        temp.next = new node(20);
        temp.next.prev = temp;
        temp = temp.next;
        temp.next = new node(10);
        temp.next.prev = temp;
        temp = temp.next;

        temp.next = new node(10);
        temp.next.prev = temp;
        temp = temp.next;
        temp.next = new node(50);
        temp.next.prev = temp;
        temp = temp.next;

        head = deletealloccurance(head, 10);


    }
}