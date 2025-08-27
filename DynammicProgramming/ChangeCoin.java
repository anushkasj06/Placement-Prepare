public class ChangeCoin {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i=0;i<=amount;i++) dp[0][i] = (i%coins[0]==0)?1:0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (coins[i] <= j) take = dp[i][j - coins[i]];
                dp[i][j] = (take + notTake);
            }
        }
        return dp[n - 1][amount];
    }


    public int ChangeCoinMemoization(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        return solve(n - 1, amount, coins, dp);
    }

    public int solve(int i, int amount, int[] coins, Integer[][] dp) {
        if (i == 0) return (amount % coins[0] == 0) ? 1 : 0;
        if (dp[i][amount] != null) return dp[i][amount];
        int notTake = solve(i - 1, amount, coins, dp);
        int take = 0;
        if (coins[i] <= amount) take = solve(i, amount - coins[i], coins, dp);
        return dp[i][amount] = (take + notTake);
    }

    public int changeSpaceOptimized(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        for(int i=0;i<=amount;i++) prev[i] = (i%coins[0]==0)?1:0;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                int notTake = prev[j];
                int take = 0;
                if (coins[i] <= j) take = curr[j - coins[i]];
                curr[j] = (take + notTake);
            }
            prev = curr;
        }
        return prev[amount];
    }
}
