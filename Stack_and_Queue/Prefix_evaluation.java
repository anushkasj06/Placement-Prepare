package Stack_and_Queue;

import java.util.Stack;

public class Prefix_evaluation {
    static boolean isOpernad(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'|| ch >= '0' && ch <= '9');
    }
    static String evaluatePrefix(String prefix) {
        int i= prefix.length();
        Stack<String> stack = new Stack<>();

        while (i >=0) {
            if(isOpernad(prefix.charAt(i))){
                stack.push(String.valueOf(prefix.charAt(i)));
            }else{
                String val1 = stack.pop();
                String val2 = stack.pop();
                String con = '('+val1+prefix.charAt(i)+val2+')';
                stack.push(con);
            }
            i--;
        }
        if(!stack.isEmpty()){
            return stack.pop();
        }
        return null;
    }

    public static void main(String[] args) {
        String prefix = "*+AB-CD";
        System.out.println(evaluatePrefix(prefix));
    }
}
