public class TargerSumSameParition {
    public int findTargetSumWays(int[] nums, int target) {
        int totalsum = 0;
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
        }
        if(totalsum-target<0 || (totalsum-target)%2!=0) return 0;
        int s=(totalsum-target)/2;
        return countSubsets(nums,s);
    }

    public int countSubsets(int[] nums, int s){
        int n = nums.length;
        int[][] dp = new int[n][s + 1];
        if(nums[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(nums[0] != 0 && nums[0] <= s) dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= s; j++) {
                int untake = dp[i - 1][j];
                int take = 0;
                if (j >= nums[i]) take = dp[i - 1][j - nums[i]];
                dp[i][j] = (untake + take);
            }
        }
        return dp[n - 1][s];
    }
}
