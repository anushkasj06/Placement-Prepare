import java.util.*;

public class BuySellStockVcooldown {
    public int buysellcooldown(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(prices, 0, 0, dp);
    }

    private int helper(int[] prices, int day, int canbuy, int[][] dp) {
        if (day >= prices.length) return 0;
        if (dp[day][canbuy] != -1) return dp[day][canbuy];

        int cooldown = helper(prices, day + 1, canbuy, dp);
        if (canbuy == 1) {
            int sell = prices[day] + helper(prices, day + 1, 0, dp);
            dp[day][canbuy] = Math.max(cooldown, sell);
        } else {
            int buy = -prices[day] + helper(prices, day + 2, 1, dp);
            dp[day][canbuy] = Math.max(cooldown, buy);
        }
        return dp[day][canbuy];
    }

    public int buysellcooldownTab(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int day = n - 1; day >= 0; day--) {
            for (int canbuy = 0; canbuy <= 1; canbuy++) {
                int profit = 0;
                if(canbuy==1){
                    profit = Math.max(dp[day + 1][1], -prices[day] + dp[day + 1][0]);
                }else{
                    profit = Math.max(dp[day + 1][0], prices[day] + dp[day + 2][1]);
                }
                dp[day][canbuy] = profit;
            }
        }
        return dp[0][1];
    }
}