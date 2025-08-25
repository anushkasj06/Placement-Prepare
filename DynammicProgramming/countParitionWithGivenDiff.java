public class countParitionWithGivenDiff {
    public int countparitionwithDdiff(int[] nums, int d){
        int n = nums.length;
        int totalSum =0;
        for(int num : nums) totalSum += num;
        int tar = (totalSum - d) / 2;
        int[][] dp = new int[n][tar+1];
        return func(n-1, tar, nums,dp);
    }

    public static int func(int i, int tar, int[] nums, int[][] dp){
        if(i==0){
            if(tar==0 && nums[0]==0) return 2;
            if(nums[0]==tar || tar==0) return 1;
            else return 0;
        }
        if(dp[i][tar]!=0) return dp[i][tar];
        int untake = func(i-1, tar, nums, dp);
        int take = 0;
        if(tar>=nums[i]) take = func(i-1, tar-nums[i], nums, dp);
        return dp[i][tar] = (untake + take) % 1000000007;
    }

    public int countPartitionsWithGivenDiffTabulation(int[] nums, int d) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        int tar = (totalSum - d) / 2;
        int[][] dp = new int[n][tar + 1];
        if(nums[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(nums[0] != 0 && nums[0] <= tar) dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= tar; j++) {
                int untake = dp[i - 1][j];
                int take = 0;
                if (j >= nums[i]) take = dp[i - 1][j - nums[i]];
                dp[i][j] = (untake + take) % 1000000007;
            }
        }
        return dp[n - 1][tar];
    }
}
