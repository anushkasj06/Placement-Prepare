
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        int prev = 1;
        int curr = 1;
        for(int i=2; i<=n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }
}
