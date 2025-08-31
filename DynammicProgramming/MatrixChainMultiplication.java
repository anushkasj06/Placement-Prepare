import java.util.*;


class MatrixChainMultiplication{
public int MatrixChainMultiplicationproblem(int[] arr, int n){
    return solve(arr, 1, n - 1);
}

public static int solve(int[] arr, int i, int j) {
    if (i == j) return 0;

    int min = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
        int count = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
        if (count < min) min = count;
    }
    return min;
}


public int solveMemo(int[] arr, int i, int j, int[][] dp) {
    if (i == j) return 0;
    if (dp[i][j] != -1) return dp[i][j];

    int min = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
        int count = solveMemo(arr, i, k, dp) + solveMemo(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
        if (count < min) min = count;
    }
    return dp[i][j] = min;
}

public int MatrixChainMultiplicationproblemMemo(int[] arr, int n){
    int[][] dp = new int[n][n];
    for(int[] row : dp)
        Arrays.fill(row, -1);
    return solveMemo(arr, 1, n - 1, dp);
}

public int MatrixChainMultiplicationproblemTabu(int[] arr, int n){
    int[][] dp = new int[n][n];

    for(int i = 1; i < n; i++){
        dp[i][i] = 0;
    }

    

    for(int i=n-1;i>=1;i--){
        for(int j=i;j<n;j++){
            dp[i][j] = Integer.MAX_VALUE;
            for(int k=i;k<j;k++){
                int count = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                if(count < dp[i][j]) dp[i][j] = count;
            }
        }
    }
    return dp[1][n - 1];
}

}