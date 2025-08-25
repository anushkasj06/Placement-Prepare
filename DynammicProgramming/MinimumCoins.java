import java.util.*;

public class MinimumCoins {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        return func(n-1, amount, coins, dp);
    }

    private int func(int i, int amount, int[] coins, int[][] dp) {
       if(i==0){
        if(amount%coins[0]==0) return amount/coins[0];
        else return (int)1e9;
       }
       if(dp[i][amount]!=0) return dp[i][amount];
       int notTake = func(i-1, amount, coins, dp);
       int take = (int)1e9;
       if(coins[i]<=amount) take = func(i, amount-coins[i], coins, dp)+1;
       return dp[i][amount] = Math.min(take, notTake);
    }

    public int coinChangeTabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) dp[0][j] = j / coins[0];
            else dp[0][j] = (int) 1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int notTake = dp[i - 1][j];
                int take = (int) 1e9;
                if (coins[i] <= j) take = dp[i][j - coins[i]] + 1;
                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[n - 1][amount] >= (int) 1e9 ? -1 : dp[n - 1][amount];
    }

    public int coinChangeSpaceOptimized(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) prev[j] = j / coins[0];
            else prev[j] = (int) 1e9;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                int notTake = prev[j];
                int take = (int) 1e9;
                if (coins[i] <= j) take = curr[j - coins[i]] + 1;
                curr[j] = Math.min(take, notTake);
            }
            prev = curr;
        }
        return prev[amount] >= (int) 1e9 ? -1 : prev[amount];
    }
}
