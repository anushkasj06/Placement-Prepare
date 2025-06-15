package LinkedList;

public class remove_dupl_form_DLL_sorted {
    public static class node{
        int data;
        node next;
        node prev;
        node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }


    public static node remove_dupl(node head){
        node temp = head;
        while(temp!=null && temp.next!=null){
            node next = temp.next;
            while (next!=null && next.data == temp.data){
                node dup = next;
                next = next.next;
                dup.next = null;
                dup.prev = null;
            


            }
            temp.next = next;
            if(next!=null){
                next.prev = temp;
            }
            temp = temp.next;

            
        }
        return head;

    }

    public static void main(String[] args) {
        node head = new node(10);
        node temp = head;
        
    }

}
