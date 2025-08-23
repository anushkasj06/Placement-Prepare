public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public int pathSumMemorization(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][] memo = new Integer[n][m];
        return findMinPath(grid, n - 1, m - 1, memo);
    }

    private int findMinPath(int[][] grid, int i, int j, Integer[][] memo) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[0][0];
        if (memo[i][j] != null) return memo[i][j];

        int up = findMinPath(grid, i - 1, j, memo);
        int left = findMinPath(grid, i, j - 1, memo);
        memo[i][j] = grid[i][j] + Math.min(up, left);
        return memo[i][j];
    }

}
