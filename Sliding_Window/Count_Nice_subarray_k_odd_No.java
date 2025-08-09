package Sliding_Window;

public class Count_Nice_subarray_k_odd_No {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSubarraysWithKOdd(nums, k) - countSubarraysWithKOdd(nums, k - 1);
    }

    private int countSubarraysWithKOdd(int[] nums, int k) {
        int count = 0;
        int l = 0;
        int r = 0;
        int sum=0;

        while (r < nums.length) {
            sum += nums[r]%2;
            while (sum > k) {
                sum -= nums[l]%2;
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
}
