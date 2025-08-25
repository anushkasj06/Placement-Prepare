import java.util.*;

public class ParitionTwoSubsetMinSumDiff{

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum / 2;  // ✅ Only go up to half of the total sum
        boolean[][] dp = new boolean[n][target + 1];

        // Base case: we can always make sum 0
        for (int i = 0; i < n; i++) dp[i][0] = true;

        // First element initialization
        if (nums[0] <= target) dp[0][nums[0]] = true;

        // DP computation
        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean untake = dp[i - 1][t];
                boolean take = false;
                if (t >= nums[i]) take = dp[i - 1][t - nums[i]];
                dp[i][t] = take || untake;
            }
        }

        // Find minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= target; i++) {
            if (dp[n - 1][i]) {
                int diff = totalSum - 2 * i;  // ✅ Correct formula
                minDiff = Math.min(minDiff, diff);
            }
        }
        return minDiff;
    }
}

