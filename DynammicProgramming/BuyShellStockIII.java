public class BuyShellStockIII {
    public int buyshellstockmemo(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        return maxProfitHelper(0, 1, 2, prices, dp);
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

    public int BuyShellStockIIITabu(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        //no need to write base case becuse already for all i,canbuy where remainingTransactions=0 is already 0 , same for i =0;
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int remainingTransactions = 1; remainingTransactions <= 2; remainingTransactions++) { //for remainingTransactions = 0 is alredy zero so no need to do for it
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
        return dp[0][1][2];
    }

    public int BuyShellStockIIISpaceOpt(int[] prices) {
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int remainingTransactions = 1; remainingTransactions <= 2; remainingTransactions++) {
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
        return ahead[1][2];
    }


    // type 2 of solving using dp[n][transactions] 0,1,2,3
    public int buyshelltyp2memo(int[] price){
        return memohelper(0, 0,price);
    }
    public static int memohelper(int ind, int transactions, int[] prices){
        if(ind==prices.length || transactions==4) return 0;
        int profit = 0;
        if(transactions%2==0){
            profit = Math.max(-prices[ind]+memohelper(ind+1,transactions+1,prices), memohelper(ind+1,transactions,prices));
        }else{
            profit = Math.max(prices[ind]+memohelper(ind+1,transactions+1,prices), memohelper(ind+1,transactions,prices));
        }
        return profit;
    }


    public int buyshelltype2tabu(int[] prices){
        int[][] dp = new int[prices.length + 1][4];
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int transactions = 0; transactions <= 3; transactions++) {
                if (transactions % 2 == 0) {
                    dp[ind][transactions] = Math.max(-prices[ind] + dp[ind + 1][transactions + 1], dp[ind + 1][transactions]);
                } else {
                    dp[ind][transactions] = Math.max(prices[ind] + dp[ind + 1][transactions + 1], dp[ind + 1][transactions]);
                }
            }
        }
        return dp[0][0];
    }

    public int buyshelltype2spaceopt(int[] prices){
        int[] ahead = new int[4];
        int[] curr = new int[4];
        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int transactions = 0; transactions <= 3; transactions++) {
                if (transactions % 2 == 0) {
                    curr[transactions] = Math.max(-prices[ind] + ahead[transactions + 1], ahead[transactions]);
                } else {
                    curr[transactions] = Math.max(prices[ind] + ahead[transactions + 1], ahead[transactions]);
                }
            }
            ahead = curr;
        }
        return ahead[0];
    }

}
