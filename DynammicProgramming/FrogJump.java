
public class FrogJump {
    public int frogJump(int n, int[] h){
        int[] dp = new int[n + 1];
        return f(n-1, h, dp);
    }

    public int f(int i, int[] h, int[] dp) {
        if (i == 0) return 0;
        if (dp[i] != 0) return dp[i];
        int left = f(i - 1, h, dp) + Math.abs(h[i] - h[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) right = f(i - 2, h, dp) + Math.abs(h[i] - h[i - 2]);
        dp[i] = Math.min(left, right);
        return dp[i];
    }

    public int frogJumpTabulation(int n, int[] h) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(h[1] - h[0]);
        for (int i = 2; i <n; i++) {
            int left = dp[i - 1] + Math.abs(h[i] - h[i - 1]);
            int right = dp[i - 2] + Math.abs(h[i] - h[i - 2]);
            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }

    public int frogJumpSpaceOptimized(int n, int[] h) {
        int prev2 = 0;
        int prev1 = Math.abs(h[1] - h[0]);
        for (int i = 2; i < n; i++) {
            int left = prev1 + Math.abs(h[i] - h[i - 1]);
            int right = prev2 + Math.abs(h[i] - h[i - 2]);
            int curr = Math.min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
