import java.util.Arrays;

public class NinjaTechnique {
    public int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        Arrays.fill(dp,-1);
        return f(n-1, 3, points, dp);
    }

    public int f(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int max = 0;
            for (int k = 0; k < 3; k++) {
                if (k != last) {
                    max = Math.max(max, points[0][k]);
                }
            }
            return max;
        }
        if (dp[day][last] != -1) return dp[day][last];
        int max = 0;
        for (int k = 0; k < 3; k++) {
            if (k != last) {
                max = Math.max(max, points[day][k] + f(day - 1, k, points, dp));
            }
        }
        return dp[day][last] = max;
    }
}
