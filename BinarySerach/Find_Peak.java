public class Find_Peak {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; // or throw an exception
        }
        int n = nums.length;
        if(n==1) return 0; // Only one element, which is the peak
        if(nums[0] > nums[1]) return 0; // First element is peak
        if(nums[n-1] > nums[n-2]) return n-1; //
        int low = 1;
        int high = n-2;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(nums[mid]> nums[mid-1]){
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }
        return -1; // Should not reach here if input is valid

    }
}
