package LinkedList;

public class delete_duplicate_II {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }

    }

     public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        boolean flag = false;
        while(curr!=null && curr.next!=null){
            ListNode temp = curr.next;
            
            while(temp!=null && curr.val == temp.val){
                temp = temp.next;
                flag = true;
            }

            if(flag == true){
                if(curr==head){
                    head = temp;
                }
                if(prev!=null){
                    prev.next = temp;
                }
                curr = temp;
                flag = false;
            }else{
                prev = curr;
                curr = curr.next;
            }

        }
        return head;
    }
}
