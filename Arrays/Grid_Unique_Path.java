import java.util.Arrays;

public class Grid_Unique_Path {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2; // Total steps to reach the bottom-right corner
        int r = m - 1; // Steps down (or right)
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N -r+i) / i;
        }
        return (int) res;
    }


    public int uniquePathsDP(int m, int n) {
        int ans[][] = new int[m][n];
        Arrays.fill(ans, -1); // Fill the first row and column with 1s
        int path = count(0,0, m, n, ans);
        return path;
    }
    public int count(int i, int j, int m, int n, int[][] ans) {
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1; // Reached the destination
        if(ans[i][j] != -1) return ans[i][j]; // Return
        // already computed value
        ans[i][j] = count(i + 1, j, m, n, ans) + count(i, j + 1, m, n, ans);
        return ans[i][j];
    }



}
