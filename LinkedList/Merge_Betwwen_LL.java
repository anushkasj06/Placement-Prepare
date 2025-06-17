package LinkedList;

public class Merge_Betwwen_LL {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }   
    }


     public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        ListNode tail2 = findtail(list2);
        int count =0;
        ListNode prev = null;
        while(curr!=null){
            if(count == a){
                if(prev!=null){
                    prev.next = list2;
                }
                if(a==0){
                    list1 = list2;
                }
            }

            if(count == b){
                tail2.next = curr.next;
            }
            prev = curr;
            curr=curr.next;
            count++;
        }
        return list1;
    }

    private static ListNode findtail(ListNode head){
        ListNode curr = head;
        while(curr.next !=null){
            curr = curr.next;
        }
        return curr;
    }
}
