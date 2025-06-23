import java.util.Stack;

public class Remove_Adjacent_duplicate {
     public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.size()==0){
                st.push(ch);
            }else{
                if(st.peek()==ch){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }
        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
