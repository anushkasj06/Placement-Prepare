public class BuyShellStockII {
    public int maxProfitIIrec(int[] prices) {
        return maxProfitHelper(0, 1, prices);
    }

    private int maxProfitHelper(int ind, int canBuy, int[] prices) {
        if (ind >= prices.length) return 0;

        if (canBuy == 1) {
            // We can buy
            int buy = -prices[ind] + maxProfitHelper(ind + 1, 0, prices);
            int notBuy = maxProfitHelper(ind + 1, 1, prices);
            return Math.max(buy, notBuy);
        } else {
            // We can sell
            int sell = prices[ind] + maxProfitHelper(ind + 1, 1, prices);
            int notSell = maxProfitHelper(ind + 1, 0, prices);
            return Math.max(sell, notSell);
        }
    }

    public int maxProfitIITabu(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 1) {
                    // We can buy
                    int buy = -prices[ind] + dp[ind + 1][0];
                    int notBuy = dp[ind + 1][1];
                    dp[ind][1] = Math.max(buy, notBuy);
                } else {
                    // We can sell
                    int sell = prices[ind] + dp[ind + 1][1];
                    int notSell = dp[ind + 1][0];
                    dp[ind][0] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][1];
    }

    public int maxProfitSOby2sizearray(int[] prices){
        int[] ahead = new int[2];
        ahead[0] = 0; // aheadNotBuy
        ahead[1] = 0; // aheadBuy
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            int[] curr = new int[2];
            // We can buy
            int buy = -prices[ind] + ahead[0];
            int notBuy = ahead[1];
            curr[1] = Math.max(buy, notBuy);

            // We can sell
            int sell = prices[ind] + ahead[1];
            int notSell = ahead[0];
            curr[0] = Math.max(sell, notSell);

            ahead = curr;
        }
        return ahead[1];
    }

    public int maxProfitIIOpti(int[] prices) {
        int aheadBuy = 0, aheadNotBuy = 0;
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            int currBuy = 0, currNotBuy = 0;
            // We can buy
            int buy = -prices[ind] + aheadNotBuy;
            int notBuy = aheadBuy;
            currBuy = Math.max(buy, notBuy);

            // We can sell
            int sell = prices[ind] + aheadBuy;
            int notSell = aheadNotBuy;
            currNotBuy = Math.max(sell, notSell);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadBuy;
    }
}
