public class MaximumFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        int min = Integer.MAX_VALUE;
        for(int j=0;j<m;j++) {
            int ans = func(n-1,j,dp,matrix);
            min = Math.min(min, ans);
        }
        return min;
    }

    private int func(int i, int j, int[][] dp, int[][] matrix) {
        if(j < 0 || j >= matrix[0].length) return (int)1e9;
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];

        int down = matrix[i][j] + func(i-1,j,dp,matrix);
        int left = matrix[i][j] + func(i-1,j-1,dp,matrix);
        int right = matrix[i][j] + func(i-1,j+1,dp,matrix);

        return dp[i][j] = Math.min(down, Math.min(left, right));
    }


    public int minFallingPathSumTabulization(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int j=0;j<m;j++) {
            dp[0][j] = grid[0][j];
        }

        for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                int down = grid[i][j] + dp[i-1][j];
                int left = grid[i][j] + (j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE);
                int right = grid[i][j] + (j < m-1 ? dp[i-1][j+1] : Integer.MAX_VALUE);
                dp[i][j] = Math.min(down, Math.min(left, right));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j=0;j<m;j++) {
            min = Math.min(min, dp[n-1][j]);
        }
        return min;
    }
}
