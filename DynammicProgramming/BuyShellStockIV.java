public class BuyShellStockIV {

    //you can buy and sell stock at most k times
    public int buyshellstockIV(int[] prices, int k) {
        int[][][] dp = new int[prices.length][2][k + 1];
        return maxProfitHelper(0, 1, k , prices, dp);
    }

    public static int maxProfitHelper(int ind, int canBuy, int remainingTransactions, int[] prices, int[][][] dp) {
        if (ind == prices.length || remainingTransactions == 0) return 0;

        if (dp[ind][canBuy][remainingTransactions] != 0) return dp[ind][canBuy][remainingTransactions];

        if (canBuy == 1) {
            // We can buy
            int buy = -prices[ind] + maxProfitHelper(ind + 1, 0, remainingTransactions, prices, dp);
            int notBuy = maxProfitHelper(ind + 1, 1, remainingTransactions, prices, dp);
            dp[ind][canBuy][remainingTransactions] = Math.max(buy, notBuy);
        } else {
            // We can sell
            int sell = prices[ind] + maxProfitHelper(ind + 1, 1, remainingTransactions - 1, prices, dp);
            int notSell = maxProfitHelper(ind + 1, 0, remainingTransactions, prices, dp);
            dp[ind][canBuy][remainingTransactions] = Math.max(sell, notSell);
        }
        return dp[ind][canBuy][remainingTransactions];
    }

    public int buyshellstockIVTabu(int[] prices, int k) {
        int[][][] dp = new int[prices.length + 1][2][k + 1];
        //no need to write base case becuse already for all i,canbuy where remainingTransactions=0 is already 0 , same for i =0;
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int remainingTransactions = 1; remainingTransactions <= k; remainingTransactions++) { //for remainingTransactions = 0 is alredy zero so no need to do for it
                    if (canBuy == 1) {
                        // We can buy
                        int buy = -prices[ind] + dp[ind + 1][0][remainingTransactions];
                        int notBuy = dp[ind + 1][1][remainingTransactions];
                        dp[ind][canBuy][remainingTransactions] = Math.max(buy, notBuy);
                    } else {
                        // We can sell
                        int sell = prices[ind] + dp[ind + 1][1][remainingTransactions - 1];
                        int notSell = dp[ind + 1][0][remainingTransactions];
                        dp[ind][canBuy][remainingTransactions] = Math.max(sell, notSell);
                    }
                }
            }
        }
        return dp[0][1][k];
    }

    public int buyshellstockIVSpaceOpt(int[] prices, int k) {
        int[][] ahead = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int remainingTransactions = 1; remainingTransactions <= k; remainingTransactions++) {
                    if (canBuy == 1) {
                        // We can buy
                        int buy = -prices[ind] + ahead[0][remainingTransactions];
                        int notBuy = ahead[1][remainingTransactions];
                        curr[1][remainingTransactions] = Math.max(buy, notBuy);
                    } else {
                        // We can sell
                        int sell = prices[ind] + ahead[1][remainingTransactions - 1];
                        int notSell = ahead[0][remainingTransactions];
                        curr[0][remainingTransactions] = Math.max(sell, notSell);
                    }
                }
            }
            ahead = curr;
        }
        return ahead[1][k];
    }


    //types two : using dp[n][ktransaction]
    public int buyshellstockIVType2(int[] prices, int k) {
        int[][] dp = new int[prices.length + 1][k + 1];
        return helper(0, 0,k, prices, dp);
    }

    public int helper(int ind, int TransNo, int k, int[] prices,int[][] dp) {
        if(ind==prices.length || TransNo==2*k) return 0;
        if(dp[ind][TransNo]!=-1) return dp[ind][TransNo];
        int profit = 0;
        if(TransNo%2==0) {
            // Buy
            profit = Math.max(-prices[ind] + helper(ind + 1, TransNo + 1, k, prices, dp), helper(ind + 1, TransNo, k, prices, dp));
        } else {
            // Sell
            profit = Math.max(prices[ind] + helper(ind + 1, TransNo + 1, k, prices, dp), helper(ind + 1, TransNo, k, prices, dp));
        }
        return dp[ind][TransNo] = profit;
    }

    public int buyshellstockIVType2Tabu(int[] prices, int k) {
        int[][] dp = new int[prices.length + 1][k + 1];
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int TransNo = 0; TransNo < 2 * k; TransNo++) {
                if (TransNo % 2 == 0) {
                    // Buy
                    dp[ind][TransNo] = Math.max(-prices[ind] + dp[ind + 1][TransNo + 1], dp[ind + 1][TransNo]);
                } else {
                    // Sell
                    dp[ind][TransNo] = Math.max(prices[ind] + dp[ind + 1][TransNo + 1], dp[ind + 1][TransNo]);
                }
            }
        }
        return dp[0][0];
    }

    public int buyshellstockIVType2SpaceOpt(int[] prices, int k) {
        int[] ahead = new int[2*k+1];
        int[] curr = new int[2*k+1];
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int TransNo = 0; TransNo < 2 * k; TransNo++) {
                if (TransNo % 2 == 0) {
                    // Buy
                    curr[TransNo] = Math.max(-prices[ind] + ahead[TransNo + 1], ahead[TransNo]);
                } else {
                    // Sell
                    curr[TransNo] = Math.max(prices[ind] + ahead[TransNo + 1], ahead[TransNo]);
                }
            }
            ahead = curr;
        }
        return ahead[0];
    }

}
