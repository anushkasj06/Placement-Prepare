public class RodCutting {
    public int rodcuttingMemoization(int[] price, int i, int N, int[][] dp) {
        if (i == 0) return N * price[0];
        if (dp[i][N] != -1) return dp[i][N];
        int notTake = rodcuttingMemoization(price, i - 1, N, dp);
        int take = Integer.MIN_VALUE;
        int nodelen = i + 1;
        if (nodelen <= N) take = price[i] + rodcuttingMemoization(price, i, N - nodelen, dp);
        return dp[i][N] = Math.max(take, notTake);
    }

    public int rodcuttingTabulation(int[] price, int N) {
        int n = price.length;
        int[][] dp = new int[n][N + 1];
        for (int j = 0; j <= N; j++) dp[0][j] = j * price[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= N; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                int nodelen = i + 1;
                if (nodelen <= j) take = price[i] + dp[i][j - nodelen];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][N];
    }

    public int rodcuttingSpaceOptimized(int[] price, int N) {
        int n = price.length;
        int[] prev = new int[N + 1];
        for (int j = 0; j <= N; j++) prev[j] = j * price[0];

        for (int i = 1; i < n; i++) {
            int[] curr = new int[N + 1];
            for (int j = 0; j <= N; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                int nodelen = i + 1;
                if (nodelen <= j) take = price[i] + curr[j - nodelen];
                curr[j] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[N];
    }

    public int rodcuttingSpaceOptimized1darray(int[] price, int N) {
        int n = price.length;
        int[] dp = new int[N + 1];
        for (int j = 0; j <= N; j++) dp[j] = j * price[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= N; j++) {
                int notTake = dp[j];
                int take = Integer.MIN_VALUE;
                int nodelen = i + 1;
                if (nodelen <= j) take = price[i] + dp[j - nodelen];
                dp[j] = Math.max(take, notTake);
            }
        }
        return dp[N];
    }
}
