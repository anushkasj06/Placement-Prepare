package LinkedList;



public class reverse_k_group_LL {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevnode = null;
        while(temp!=null){
            ListNode kthnode = getkthnode(temp, k);
            if(kthnode ==null){
                if(prevnode!=null){
                    prevnode.next = temp;
                    break;
                }
            }

            ListNode nextnode = kthnode.next;
            kthnode.next = null;
            reverse(temp);
            if(temp==head){
                head = kthnode;
            }else{
                prevnode.next = kthnode;
            }
            prevnode = temp;
            temp = nextnode;
        }
        return head;
    }

    private static ListNode getkthnode(ListNode temp, int k){
        k-=1;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        head = reverseKGroup(head, 2);
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
