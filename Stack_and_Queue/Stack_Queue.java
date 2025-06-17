package Stack_and_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_Queue {
     Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public Stack_Queue() {
        
    }
    
    public void push(int x) {
        if(!q1.isEmpty()){
            q1.add(x);
        }else{
            q2.add(x);
        }
    }
    
    public int pop() {
        if(empty()){
            return-1;
        }
        int result =-1;

        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                result = q1.remove();
                if(q1.isEmpty()){
                    break;
                }
                q2.add(result);
            }
        }else{
            while(!q2.isEmpty()){
                result = q2.remove();
                if(q2.isEmpty()){
                    break;
                }
                q1.add(result);
            }
        }
        return result;
    }
    
    public int top() {
         if(empty()){
            return-1;
        }
        int result =-1;

        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                result = q1.remove();
                if(q1.isEmpty()){
                    q2.add(result);
                    break;
                }
                q2.add(result);
            }
        }else{
            while(!q2.isEmpty()){
                result = q2.remove();
                if(q2.isEmpty()){
                    q1.add(result);
                    break;
                }
                q1.add(result);
            }
        }
        return result;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }


    public static void main(String[] args) {
        Stack_Queue stack = new Stack_Queue();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());
        System.out.println(stack.pop());

    }

    
}
