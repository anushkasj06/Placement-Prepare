import java.util.*;

public class CountSubsetWithSumK {
    public int CountSubsetWithSumKrev(int[] nums, int k){
        return func(nums.length-1,k, nums);
    }

    public int func(int i ,int k,  int[] nums){
        if(k==0) return 1;
        if(i==0){
            if(nums[0]==k) return 1;
            else return 0;
        }
        int untake = func(i-1, k, nums);
        int take = 0;
        if(k>=nums[i]) take = func(i-1, k-nums[i], nums);
        return untake + take;
    }

    public int CountSubsetWithSumKmemo(int[] nums, int k){
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return func2(n-1,k, nums, dp);
    }

    public int func2(int i, int k, int[] nums, int[][] dp){
        if(k==0) return 1;
        if(i==0){
            if(nums[0]==k) return 1;
            else return 0;
        }
        if(dp[i][k]!=-1) return dp[i][k];
        int untake = func2(i-1, k, nums, dp);
        int take = 0;
        if(k>=nums[i]) take = func2(i-1, k-nums[i], nums, dp);
        return dp[i][k] = untake + take;
    }


    public int CountSubsetWithSumKtab(int[] nums, int k){
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for(int i=0; i<n; i++) dp[i][0] = 1;  // Base case: sum 0 can be made with any set
        if(nums[0] <= k) dp[0][nums[0]] = 1;  // First element initialization

        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                int untake = dp[i-1][j];
                int take = 0;
                if(j >= nums[i]) take = dp[i-1][j-nums[i]];
                dp[i][j] = untake + take;
            }
        }
        return dp[n-1][k];
    }

}
