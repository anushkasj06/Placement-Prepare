import java.util.*;

public class Remove_Outermost_Parentheses {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if(st.size()>=1){
                    sb.append(ch);
                }
                st.push(ch);
            } else {
                if(st.size()>1){
                    sb.append(ch);
                }
                st.pop();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Remove_Outermost_Parentheses obj = new Remove_Outermost_Parentheses();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(obj.removeOuterParentheses(s));
        sc.close();
    }
}