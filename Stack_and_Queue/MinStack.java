package Stack_and_Queue;

import java.util.Stack;

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(val<=min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop()==min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(0);
        obj.push(3);
        obj.push(0);
        obj.pop();  
        obj.getMin();
        obj.pop();
        obj.getMin();
        obj.pop();
        obj.getMin();
    }
}
