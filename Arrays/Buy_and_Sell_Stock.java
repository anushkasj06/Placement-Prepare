public class Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            int cost = prices[i] - min; // Calculate profit if sold today
            maxProfit = Math.max(maxProfit, cost); // Update max profit
            min = Math.min(min, prices[i]); // Update minimum price seen so far
        }
        return maxProfit;
    }
}
