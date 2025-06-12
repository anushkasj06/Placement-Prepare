package LinkedList;

import java.lang.classfile.components.ClassPrinter.ListNode;

public class intersection_linkedlist {
    public static class node{
        int data;
        node next;

        node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public node getIntersectionNode(node headA, node headB) {
        if(headA==null || headB == null){
            return null;
        }
        node t1 = headA;
        node t2 = headB;
        while(t1!=t2){
            t1=t1.next;
            t2 = t2.next;
            if(t1==t2){
                return t1;

            }
            if(t1==null){
                t1 = headB;
            }
            if(t2==null){
                t2=headA;
            }
        }
        return t1;
    }

    public static void main(String[] args) {
        node headA = new node(4);
        headA.next = new node(1);

    }
}
