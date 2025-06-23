import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_first_K_Queue {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q1 = new LinkedList<>();
        int size = q.size()-k;
        if(k>q.size()){
            return q;
        }
        
        for(int i=0;i<k;i++){
            s.push(q.remove());
        }
        
        while(!s.isEmpty()){
            q1.add(s.pop());
        }
        
        for(int i=0;i<size;i++){
            q1.add(q.remove());
        }
        return q1;
    }
}
