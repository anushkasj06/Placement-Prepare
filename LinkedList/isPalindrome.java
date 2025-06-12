package LinkedList;
import java.util.*;

public class isPalindrome{
    public static class node{
        int data;
        node next;

        node(int data){
            this.data = data;
            this.next = null;
        }

    }
    public static boolean isPalindrome(node head){
        if(head == null || head.next == null){
            return true;
        }
        node slow = head;
        node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }
        node prev = null,  curr = slow;
        while(curr!=null){
            node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }

        node first = head;
        node second = prev;
        while(second!=null){
            if(first.data!=second.data){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;

            

    }

    public static void main(String[] args) {
        node head = new node(1);
        head.next = new node(2);
        head.next.next = new node(3);       
        head.next.next.next = new node(2);
        head.next.next.next.next = new node(1);
        System.out.println(isPalindrome(head));

    }

}

