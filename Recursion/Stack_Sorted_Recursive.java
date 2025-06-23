package Recursion;

import java.util.Stack;

public class Stack_Sorted_Recursive {
     static void insertInSortedOrder(Stack<Integer> stack, int value) {
        // Base case: stack is empty or value is greater than top
        if (stack.isEmpty() || value > stack.peek()) {
            stack.push(value);
            return;
        }

        // Remove the top and recurse
        int top = stack.pop();
        insertInSortedOrder(stack, value);

        // Push the top back after inserting value
        stack.push(top);
    }

    // Main recursive function to sort the stack
    static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();
        sortStack(stack); // Sort remaining stack
        insertInSortedOrder(stack, top); // Insert top in sorted order
    }

    // Utility function to print stack
    static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    // Main
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}
