

import java.util.Stack;

public class Remove_K_digit {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k>0 && st.peek()-'0'>num.charAt(i)-'0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0 ){
                st.pop();
                k--;
            }
            if(st.isEmpty()){
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            while(sb.length()!=0 && sb.charAt(sb.length()-1)=='0'){
                sb.deleteCharAt(sb.length()-1);
            }
            if(sb.length()==0){
                return "0";
            }
            else{
                return sb.reverse().toString();
            }
    }
}
