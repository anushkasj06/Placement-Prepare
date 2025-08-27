public class unBoundedKnapsnack {
    public int unboundedknapsackmemoization(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n][W + 1];
        return func(n - 1, W, wt, val, dp);
    }

    public int func(int i, int W, int[] wt, int[] val, int[][] dp) {
        if (i == 0) return (W / wt[0]) * val[0];
        if (dp[i][W] != 0) return dp[i][W];
        int notTake = func(i - 1, W, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if (wt[i] <= W) take = val[i] + func(i, W - wt[i], wt, val, dp);
        return dp[i][W] = Math.max(take, notTake);
    }

    public int unboundedknapsackTabulation(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n][W + 1];
        for (int j = 0; j <= W; j++) dp[0][j] = (j / wt[0]) * val[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= j) take = val[i] + dp[i][j - wt[i]];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][W];
    }

    public int unboundedknapsackSpaceOptimized(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[] prev = new int[W + 1];
        for (int j = 0; j <= W; j++) prev[j] = (j / wt[0]) * val[0];

        for (int i = 1; i < n; i++) {
            int[] curr = new int[W + 1];
            for (int j = 0; j <= W; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= j) take = val[i] + curr[j - wt[i]];
                curr[j] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[W];
    }

    public int unboundedknapsackSpaceOptimized1darray(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[] dp = new int[W + 1];
        for (int j = 0; j <= W; j++) dp[j] = (j / wt[0]) * val[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int notTake = dp[j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= j) take = val[i] + dp[j - wt[i]];
                dp[j] = Math.max(take, notTake);
            }
        }
        return dp[W];
    }
}
