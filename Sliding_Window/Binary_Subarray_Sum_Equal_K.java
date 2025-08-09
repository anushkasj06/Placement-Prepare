package Sliding_Window;

public class Binary_Subarray_Sum_Equal_K {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return countSubarraysWithSumLessEqualK(nums, goal) - countSubarraysWithSumLessEqualK(nums, goal - 1);
    }

    private int countSubarraysWithSumLessEqualK(int[] nums, int k) {
       if (k < 0) return 0;
       int count = 0;
       int sum = 0;
       int l=0;
       int r =0;
       while(r<nums.length){
           sum += nums[r];
           while(sum>k){
               sum -= nums[l];
               l++;
           }
           count += r-l+1;
           r++;
       }
       return count;
    }
}
