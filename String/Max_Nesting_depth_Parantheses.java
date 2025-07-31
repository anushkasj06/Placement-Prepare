package String;

public class Max_Nesting_depth_Parantheses {
     public int maxDepth(String s) {
        int ans =0;
        int openBracket =0;
        for(Character c : s.toCharArray()){
            if(c=='('){
                openBracket++;
            }else if(c==')'){
                openBracket--;
            }

            ans = Math.max(ans, openBracket);
        }
        return ans;
    }
}
