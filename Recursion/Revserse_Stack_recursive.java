
import java.util.Stack;

public class Revserse_Stack_recursive {
    static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }

    // Function to reverse the stack using recursion
    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }

    // Utility function to print the stack
    static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack:");
        printStack(stack);

        reverseStack(stack);

        System.out.println("Reversed Stack:");
        printStack(stack);
    }
}
