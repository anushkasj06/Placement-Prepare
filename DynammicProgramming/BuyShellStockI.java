public class BuyShellStockI {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = 0;
        for (int i = 1; i < prices.length; i++) {
            int prof = prices[i] - prices[min];
            maxProfit = Math.max(maxProfit, prof);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }
}
