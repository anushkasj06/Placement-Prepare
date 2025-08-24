public class SubsetSumWithK {
    public boolean subsetSumK(int[] nums, int target){
        int n = nums.length;
        return func(n-1, target, nums);
    }

    public boolean func(int i, int target, int[] nums){
        if(target==0){
            return true;
        }
        if(i == 0) return nums[0]==target;
        boolean notTake = func(i-1, target, nums);
        boolean take = false;
        if(target >= nums[i])
        take = func(i-1, target - nums[i], nums);
        return take || notTake;
    }

    public boolean subsetSumKMemoization(int[] nums, int target) {
        Integer[][] dp = new Integer[nums.length][target + 1];
        return funcMemo(nums.length - 1, target, nums, dp);
    }

    public boolean funcMemo(int i, int target, int[] nums, Integer[][] dp) {
        if (target == 0) {
            return true;
        }
        if (i == 0) return nums[0] == target;
        if (dp[i][target] != null) return dp[i][target] == 1;
        boolean notTake = funcMemo(i - 1, target, nums, dp);
        boolean take = false;
        if (target >= nums[i]) take = funcMemo(i - 1, target - nums[i], nums, dp);
        dp[i][target] = (take || notTake) ? 1 : 0;
        return dp[i][target] == 1;
    }


    public boolean subsetSumKTabulation(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true; // Target 0 can always be achieved with empty subset
        }

        if (nums[0] <= target) {
            dp[0][nums[0]] = true; // If the first number is less than or equal to target
        }

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean notTake = dp[i - 1][t];
                boolean take = false;
                if (t >= nums[i]) {
                    take = dp[i - 1][t - nums[i]];
                }
                dp[i][t] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }


    public boolean subsetSumKSpaceOptimized(int[] nums, int target) {
        int n = nums.length;
        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];

        prev[0] = true; // Target 0 can always be achieved with empty subset
        if (nums[0] <= target) {
            prev[nums[0]] = true; // If the first number is less than or equal to target
        }

        for (int i = 1; i < n; i++) {
            curr[0] = true; // Target 0 can always be achieved with empty subset
            for (int t = 1; t <= target; t++) {
                boolean notTake = prev[t];
                boolean take = false;
                if (t >= nums[i]) {
                    take = prev[t - nums[i]];
                }
                curr[t] = take || notTake;
            }
            prev = curr;
        }
        return prev[target];
    }

}
