
public class frogJumpByK {
    public int frogJumpBykdist(int n , int[] h, int k){
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= k && i - j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(h[i] - h[i - j]));
            }
        }
        return dp[n-1];
    }

    
}
