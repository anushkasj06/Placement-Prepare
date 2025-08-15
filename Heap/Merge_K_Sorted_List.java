package Heap;
import java.util.*;

public class Merge_K_Sorted_List {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class pair{
        int value;
        ListNode node;
        pair(int value, ListNode node) {
            this.value = value;
            this.node = node;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        for (ListNode list : lists) {
            if (list != null) pq.offer(new pair(list.val, list));
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            pair p = pq.poll();
            temp.next = p.node;
            temp = temp.next;
            if (p.node.next != null) pq.offer(new pair(p.node.next.val, p.node.next));
        }

        return dummy.next;
    }
}

