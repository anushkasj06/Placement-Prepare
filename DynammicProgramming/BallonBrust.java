import java.lang.reflect.Array;
import java.util.ArrayList;

public class BallonBrust {
    public int maxCoinsMemo(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> balloons = new ArrayList<>();
        balloons.add(1);
        for (int x : nums) {
            balloons.add(x);
        }
        balloons.add(1);
        int[][] dp = new int[balloons.size()][balloons.size()];

        return solve(balloons, 1, balloons.size() - 2, dp);
    }

    private int solve(ArrayList<Integer> balloons, int i, int j, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        int maxCoins = 0;

        for (int k = i; k <= j; k++) {
            int coins = balloons.get(i - 1) * balloons.get(k) * balloons.get(j + 1)
                       + solve(balloons, i, k - 1, dp)
                       + solve(balloons, k + 1, j, dp);

            maxCoins = Math.max(maxCoins, coins);
        }

        return dp[i][j] = maxCoins;
    }


    public int maxCoinTabu(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> balloons = new ArrayList<>();
        balloons.add(1);
        for (int x : nums) {
            balloons.add(x);
        }
        balloons.add(1);
        int[][] dp = new int[balloons.size()+1][balloons.size()+1];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int maxCoins = 0;

                for (int k = i; k <= j; k++) {
                    int coins = balloons.get(i - 1) * balloons.get(k) * balloons.get(j + 1)
                               + dp[i][k - 1]
                               + dp[k + 1][j];

                    maxCoins = Math.max(maxCoins, coins);
                }

                dp[i][j] = maxCoins;
            }
        }

        return dp[1][n];
    }
}
