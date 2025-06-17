package LinkedList;

public class PartitonList_85 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



    public ListNode partition(ListNode head, int x) {
        ListNode dummysmall = new ListNode(-1);
        ListNode dummygreat = new ListNode(-1);

        ListNode temp1 = dummysmall;
        ListNode temp2 = dummygreat;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            if(curr.val <x){
                temp1.next = curr;
                curr.next = null;
                temp1 = temp1.next;
                curr = next;
            }else{
                temp2.next = curr;
                curr.next=null;
                temp2 = temp2.next;
                curr = next;
            }
        }

        temp1.next = dummygreat.next;
        return dummysmall.next;
        
    }
}
