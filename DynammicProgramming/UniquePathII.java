public class UniquePathII {
    public static int UniquePathIISpaceOptimzation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {

                // If obstacle, set paths = 0
                if (grid[i][j] == 1) {
                    cur[j] = 0;
                }
                // Starting cell initialization
                else if (i == 0 && j == 0) {
                    cur[j] = 1;
                } else {
                    int up = 0, left = 0;
                    // Check from top
                    if (i > 0) up = prev[j];
                    // Check from left
                    if (j > 0) left = cur[j - 1];

                    cur[j] = (up + left);
                }
            }
            prev = cur; // Update previous row
        }

        return prev[n - 1];
    }

    public static int UniquePathIIMemorization(int i, int j, int[][] grid, Integer[][] dp) {
        if (i < 0 || j < 0 || grid[i][j] == -1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != null) return dp[i][j];
        dp[i][j] = UniquePathIIMemorization(i - 1, j, grid, dp) + UniquePathIIMemorization(i, j - 1, grid, dp);
        return dp[i][j];
    }

    public static int UniquePathIIDPTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
