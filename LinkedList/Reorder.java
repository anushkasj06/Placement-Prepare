package LinkedList;
import java.util.*;

public class Reorder{
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode middle(ListNode head){
        ListNode s = head;
        ListNode f = head;
        while(f!=null && f.next!=null){
            s= s.next;
            f=f.next.next;
        }
        return s;
    }

    public ListNode reverseList(ListNode head){
        if(head==null){
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while (present!=null) {
            present.next = prev;
            prev =present;
            present = next;
            if(next != null){
                next = next.next;
            }
            
        }
        head = prev;
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode mid = middle(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;
        while(hf!=null && hs!=null){
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp=hs.next;
            hs.next=hf;
            hs=temp;
        }

        if(hf!=null){
            hf.next = null;
        }
    }
}