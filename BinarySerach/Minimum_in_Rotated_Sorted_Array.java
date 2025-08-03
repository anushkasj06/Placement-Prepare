public class Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; // or throw an exception
        }
        
        int left = 0, right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        
        while (left <=right) {
            int mid = left + (right - left) / 2;
            
            if(nums[left]<=nums[right]){
                ans = Math.min(ans, nums[left]);
                break; // The array is already sorted
            }
            if(nums[left] <= nums[mid]) {
                ans = Math.min(ans, nums[left]);
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
                ans = Math.min(ans, nums[mid]);
            }
            
        }

        return ans;
    }
}
