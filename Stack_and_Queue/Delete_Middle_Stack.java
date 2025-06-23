import java.util.Stack;

public class Delete_Middle_Stack {
    public void deleteMid(Stack<Integer> s) {
        // code here
        int n = s.size();
        int id = (n + 1) / 2;
        int times = n - id + 1;
        
        solve(s, times);
        return ;
    }
    
    void solve(Stack<Integer> s, int n){
        if(n == 1){
            s.pop();
            return;
        }
        int val = s.peek(); s.pop();
        solve(s, n - 1);
        s.push(val);
        
        return;
    }
}
