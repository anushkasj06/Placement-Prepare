package LinkedList;

public class Add_2_num {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
            this.next = null;

        }
    }

    public static node addtwonumber(node l1, node l2){
        node dummy = new node(-1);
        node curr = dummy;
        int carry = 0;
        while (l1!=null || l2!=null || carry!=0){
            int dig1 = (l1!=null)?l1.data:0;
            int dig2 = (l2!=null)?l2.data:0;
            int sum = dig1+dig2+carry;
            int dig = sum%10;
            carry = sum/10;
            node temp = new node(dig);
            curr.next = temp;
            curr = curr.next;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        node l1 = new node(2);
        l1.next = new node(4);
        l1.next.next = new node(3);
        node l2 = new node(5);
        l2.next = new node(6);
        l2.next.next = new node(4);
        node res = addtwonumber(l1,l2);
        while (res!=null){
            System.out.print(res.data+" ");
            res = res.next; 
        }
    }
}
