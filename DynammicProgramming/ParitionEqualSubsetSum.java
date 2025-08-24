import java.util.*;

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) return false;
        int target = total / 2;
        return subsetSumKSpaceOptimized(nums, target);
    }

    public boolean subsetSumKSpaceOptimized(int[] nums, int target) {
        int n = nums.length;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;

        if (nums[0] <= target) {
            prev[nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[target + 1];  // NEW LINE ✅
            curr[0] = true;

            for (int t = 1; t <= target; t++) {
                boolean notTake = prev[t];
                boolean take = false;
                if (t >= nums[i]) {
                    take = prev[t - nums[i]];
                }
                curr[t] = take || notTake;
            }

            prev = curr;  // Safe now ✅
        }
        return prev[target];
    }
}
