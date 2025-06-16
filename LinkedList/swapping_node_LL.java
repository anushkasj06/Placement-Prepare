package LinkedList;

public class swapping_node_LL {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode swapNodes(ListNode head, int k) {
        int size = findLast(head);
        int i=1;
        ListNode first = null;
        ListNode second = null;
        ListNode temp = head;
        while(temp!=null){
            if(i==k){
                first = temp;
            }
            if(i== size-k+1){
                second = temp;
            }
            temp= temp.next;
            i++;
        }

        int g = first.val;
        first.val = second.val;
        second.val = g;
        return head;

    }
    public int findLast(ListNode head){
        ListNode temp = head;
        int count =0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
