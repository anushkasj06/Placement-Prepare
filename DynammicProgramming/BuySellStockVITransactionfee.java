import java.util.*;
public class BuySellStockVITransactionfee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(prices, 0, 1, fee, dp);
    }
    public int helper(int[] prices, int i, int canbuy,int fee, int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][canbuy]!=-1) return dp[i][canbuy];

        int profit = 0;
        if(canbuy==1){
            profit = Math.max(helper(prices, i+1, 1,fee, dp), -prices[i] + helper(prices, i+1, 0,fee, dp));
        }else{
            profit = Math.max(helper(prices, i+1, 0,fee, dp), prices[i] - fee + helper(prices, i+1, 1,fee, dp));
        }
        dp[i][canbuy] = profit;
        return profit;
    }

    public int maxProfitTab(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][1] = 0;
        dp[0][0] = -prices[0] - fee;

        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
        }
        return dp[n - 1][1];
    }

    public int maxProfitSpaceOpt(int[] prices, int fee) {
        int n = prices.length;
        int aheadBuy = 0;
        int aheadNotBuy = -prices[0] - fee;

        for (int i = 1; i < n; i++) {
            int currBuy = Math.max(aheadBuy, aheadNotBuy + prices[i]);
            int currNotBuy = Math.max(aheadNotBuy, aheadBuy - prices[i] - fee);
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}
