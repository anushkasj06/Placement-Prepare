package Stack_and_Queue;

import java.util.Stack;

public class Postfix_evaluation {
    static boolean isDigit(String token) {
        int n = Integer.parseInt(token);
        if (n >= 0 && n <= 9) {
            return true;
        } else {
            return false;
        }
    }

    static int evaluatePostfix(String[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (String token : arr) {
            
            // If the token is a number, push it onto the stack
            if (isDigit(token)) {  
                stack.push(Integer.parseInt(token));
            } 
            
            // Otherwise, it must be an operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(val2 + val1);
                        break;
                    case "-":
                        stack.push(val2 - val1);
                        break;
                    case "*":
                        stack.push(val2 * val1);
                        break;
                    case "/":
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluatePostfix(arr)); 
    }
}
