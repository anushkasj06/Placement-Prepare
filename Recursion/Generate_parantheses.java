import java.util.ArrayList;
import java.util.List;

public class Generate_parantheses {
     public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,n,0,0,"");
        return res;
    }
    static void helper(List<String> res, int n, int open, int close, String str){
        if(str.length() == 2*n){
            res.add(str);
            return;
        }
        if(open<n){
            helper(res, n,open+1, close, str+"(");
        }
        if(close<open){
            helper(res,n,open, close+1,str+")");
        }
    }
}
