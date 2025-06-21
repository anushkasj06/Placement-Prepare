
import java.util.*;

public class PrefixtoPostfix {
    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        System.out.println(prefixtopostfix(prefix));
    }
    

    static String prefixtopostfix(String prefix){
        Stack<String> stack = new Stack<>();
        int n = prefix.length();
        int i = n-1;
        while (i>=0) {
            String c = String.valueOf(prefix.charAt(i));
            if(Character.isLetterOrDigit(c.charAt(0))){
                stack.push(c);
            }
            else{
                String op1 = String.valueOf(stack.pop());
                String op2 = String.valueOf(stack.pop());
                String temp = op1+op2+c;
                stack.push(temp);
            }
            i--;
        }

        return stack.pop();
    }
}
