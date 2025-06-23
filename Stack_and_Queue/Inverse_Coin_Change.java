import java.util.ArrayList;
import java.util.List;

public class Inverse_Coin_Change {
    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length;
        List<Integer> coins = new ArrayList<>();

        for (int coin = 1; coin <= n; coin++) {
            if (numWays[coin - 1] == 0) continue; // If there are 0 ways to make this amount, it can't be a coin

            // Try adding this coin and simulate DP
            List<Integer> tempCoins = new ArrayList<>(coins);
            tempCoins.add(coin);
            int[] dp = new int[n];
            dp[0] = 1;

            for (int c : tempCoins) {
                for (int i = c; i < n; i++) {
                    dp[i] += dp[i - c];
                }
            }

            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if (dp[i] > numWays[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                coins.add(coin); // only add if DP still valid
            }
        }

        // Final check: does this coin list generate the exact numWays?
        int[] finalDP = new int[n];
        finalDP[0] = 1;
        for (int c : coins) {
            for (int i = c; i < n; i++) {
                finalDP[i] += finalDP[i - c];
            }
        }
        for (int i = 0; i < n; i++) {
            if (finalDP[i] != numWays[i]) return new ArrayList<>(); // no match
        }

        return coins;
    }

    public static void main(String[] args) {
        Inverse_Coin_Change sol = new Inverse_Coin_Change();

    System.out.println(sol.findCoins(new int[]{0,1,0,2,0,3,0,4,0,5})); // [2,4,6]
    System.out.println(sol.findCoins(new int[]{1,2,2,3,4}));          // [1,2,5]
    System.out.println(sol.findCoins(new int[]{1,2,3,4,15}));         // []
    }
}
