package LinkedList;

public class Reverse_node_even_length {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseEvenLengthGroups(ListNode head) {
       ListNode dummy = head, cur = head, tail = null;
        int group = 0;
        while (cur != null) {
            group++;
            int len = 0;
            while (len < group && cur != null) {
                cur = cur.next;
                len++;
            }
            ListNode prev = null;
            cur = head;
            if (len % 2 == 0) {
                while (len > 0) {
                    ListNode next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                    len--;
                }
                if (tail != null) {
                    tail.next = prev;
                }
                tail = head;
            } else {
                while (len > 0) {
                    prev = cur;
                    cur = cur.next;
                    len--;
                }
                if (tail != null) {
                    tail.next = head;
                }
                tail = prev;
            }
            head = cur;
        }
        return dummy;

    }
}
