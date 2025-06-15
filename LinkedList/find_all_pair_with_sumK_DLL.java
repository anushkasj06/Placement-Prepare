package LinkedList;

import java.util.ArrayList;
import java.util.List;


public class find_all_pair_with_sumK_DLL {
    public static class node{
        int data;
        node next;
        node prev;
        node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    public static class pair<U, V>{
        U first;
        V second;
        pair(U first, V second){
            this.first = first;
            this.second = second;
        }
    }

    public static List<pair<Integer, Integer>> findpair(node head, int k){
        List<pair<Integer, Integer>> ans = new ArrayList<>();
        if(head == null || head.next == null){
            return ans;
        }
        node left = head;
        node right = findtail(head);
        while(left.data < right.data){
            if(left.data + right.data == k){
                ans.add(new pair<>(left.data, right.data));
                left = left.next;
                right = right.prev;
            }
            else if(left.data + right.data < k){
                left = left.next;
            }
            else{
                right = right.prev;
            }
        }
        return ans;

    }
    public static node findtail(node head){
        while(head.next != null){
            head = head.next;
        }
        return head;
    }
    public static void main(String[] args) {
        node head = new node(1);
        node temp = head;
        for(int i = 2; i <= 6; i++){
            temp.next = new node(i);
            temp.next.prev = temp;
            temp = temp.next;
        }
        List<pair<Integer, Integer>> ans = findpair(head, 7);
    }
}
