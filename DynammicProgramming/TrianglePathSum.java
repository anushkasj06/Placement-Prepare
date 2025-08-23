public class TrianglePathSum {
    public int minimumTotal(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = triangle[i][j];
                } else {
                    int up = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int leftDiagonal = (i > 0 && j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                    dp[i][j] = triangle[i][j] + Math.min(up, leftDiagonal);
                }
            }
        }

        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][j]);
        }
        return minPathSum;
    }
}
