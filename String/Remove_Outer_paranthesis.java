package String;
import java.util.*;

public class Remove_Outer_paranthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (open > 0) {
                    result.append('(');
                }
                open++;
            } else {
                open--;
                if (open > 0) {
                    result.append(')');
                }
            }
        }
        return result.toString();
    }


    public String removeOuterParentheses2(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {    
            if (c == '(') {
                if (!stack.isEmpty()) {
                    result.append(c);
                }
                stack.push(c);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}
