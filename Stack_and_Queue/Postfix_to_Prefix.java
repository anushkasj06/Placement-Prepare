
import java.util.*;


public class Postfix_to_Prefix {
    static boolean isOperand(char ch){
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9')){
            return true;
        }
        return false;
    }

    static String postfixtoprefix(String postfix){
        int n  = postfix.length();
        int i=0;
        Stack<String> st = new Stack<>();
        while(i<n){
            char ch = postfix.charAt(i);
            if(isOperand(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String op2 = st.pop();
                String op1 = st.pop();
                String temp = ch + op1 + op2;
                st.push(temp);
            }
            i++;
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String postfix = "ab*c+";
        System.out.println(postfixtoprefix(postfix));
    }
}
