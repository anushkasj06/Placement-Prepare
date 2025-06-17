package Stack_and_Queue;

public class Queue_Array {
    int front, rear, cap;
    int[] a;
    public Queue_Array(int cap) {
        this.cap = cap;
        a = new int[cap];
        front = -1;
        rear = -1;
    }

    public void enqueue(int x) {

        if (rear == cap - 1){
            System.out.println("Queue is full");
            return;
        }
        if (front == -1){
            front = 0;
        }
        rear++;
        a[rear] = x;
    }
    public int dequeue() {
        if (front == -1){
            System.out.println("Queue is empty");
            return -1;
        }
        int x = a[front];
        if (front == rear){
            front = -1;
            rear = -1;
        }
        else {
            front++;
        }
        return x;
    }
    public boolean isEmpty(){
        if (front == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (rear == cap - 1){
            return true;
        }
        return false;
    }

   public static void main(String[] args) {
       Queue_Array q = new Queue_Array(5);
       q.enqueue(1);
       q.enqueue(2);
       q.enqueue(3);
       q.enqueue(4);
       System.err.println(q.dequeue());
       System.err.println(q.dequeue());
   }

}
