package Stack_and_Queue;

import java.util.Stack;

public class Stack_Array{
    int top , cap;
    int[] a;
    
    Stack_Array(int cap){
        this.cap = cap;
        a = new int[cap];
        top = -1;   
    }

    public boolean push(int x) { 
        if (top >= cap - 1) { 
            System.out.println("Stack Overflow"); 
            return false; 
        } 
        a[++top] = x; 
        return true; 
    } 

    public int pop() { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } 
        return a[top--]; 
    } 

    public int peek() { 
        if (top < 0) { 
            System.out.println("Stack is Empty"); 
            return 0; 
        } 
        return a[top]; 
    } 

    public boolean isEmpty() { 
        return top < 0; 
    } 



    public static void main(String[] args) { 
        Stack_Array s = new Stack_Array(5); 
        s.push(10); 
        s.push(20); 
        s.push(30); 
        System.out.println(s.pop() + " popped from stack"); 

        System.out.println("Top element is: " + s.peek()); 

        System.out.print("Elements present in stack: "); 
        while (!s.isEmpty()) { 
            System.out.print(s.peek() + " "); 
            s.pop(); 
        }
    }    
}