package Sliding_Window;

public class Max_Consective_One_III {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int zeroCount = 0;

        while (r < n) {
            if (nums[r] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }

            if(zeroCount <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }

        return maxLength;
    }

    public int longestOnesOptimized(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int zeroCount = 0;

        while (r < n) {
            if (nums[r] == 0) {
                zeroCount++;
            }

            if(zeroCount >k){
                if(nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }
            if(zeroCount <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }

        return maxLength;
    }
}
