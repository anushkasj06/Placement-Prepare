package LinkedList;

public class Single_LinkedList {

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public void insertLast(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
        return;
    }

    public void insertFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        return;
    }

    public void  insertAtPos(int val, int pos){
        Node newNode = new Node(val);
        Node curr = head;
        for(int i = 1; i < pos-1; i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return;
    }

    public void deleteFirst(){
        head = head.next;
        return;
    }

    public void deleteLast(){
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
        return;
    }

    public void deleteAtPos(int pos){
        Node curr = head;
        for(int i = 1; i < pos-1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return;
    }

    public  void display(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void reverseList(Node head){
        Node curr = head;
        Node prev = null;
        Node next;  
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return;
    }

    public void search(int val){
        Node curr = head;
        while(curr != null){
            if(curr.data == val){
                System.out.println("Found");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Not Found");
        return;
    }

    public int length(Node root){
        if(root == null){
            return 0;
        }
        return 1 + length(root.next);
    }


    public static void main(String[] args) {
        Single_LinkedList list = new Single_LinkedList();
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insertLast(50);
        list.display();
        list.search(30);
        list.search(100);
        list.display();
        list.insertFirst(5);
        list.display();
        list.insertAtPos(15, 3);
        list.display();
        list.deleteFirst();
        list.display();
        list.deleteLast();
        list.display();
        list.deleteAtPos(3);
        list.display();
        list.reverseList(list.head);
        list.display();
        System.out.println(list.length(list.head));
    }
}
