import java.util.*;

public class TotalUniqueGridPath {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePathsTabulation(m, n));
    }

    public static int uniquePathMemorization(int m, int n) {
        Integer[][] dp = new Integer[m][n];
        return uniquePathMemorizationUtil(m - 1, n - 1, dp);
    }

    public static int uniquePathMemorizationUtil(int i, int j, Integer[][] dp) {
        if (i == 0 || j == 0) return 1;
        if (dp[i][j] != null) return dp[i][j];
        dp[i][j] = uniquePathMemorizationUtil(i - 1, j, dp) + uniquePathMemorizationUtil(i, j - 1, dp);
        return dp[i][j];
    }

    public static int uniquePathTabulization(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev,0);
        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    curr[j] = 1;
                } else {
                    curr[j] = prev[j] + curr[j - 1];
                }
            }
            prev = curr;
        }
        return prev[n - 1];
    }


    public static int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}