public class Floor_Ceil_Array {
    public int findFloorBS(int[] nums, int target) {
        int ans = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                ans = nums[mid]; // Update ans to the current mid
                left = mid + 1; // Move left to mid + 1 to find a potentially larger floor
            } else {
                right = mid - 1; // Move right to mid - 1 to find a smaller element
            }   
        }
        return ans;
    }

    public int findCeilBS(int[] nums, int target) {
        int ans = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                ans = nums[mid]; // Update ans to the current mid
                right = mid - 1; // Move right to mid - 1 to find a potentially smaller ceil
            } else {
                left = mid + 1; // Move left to mid + 1 to find a larger element
            }   
        }
        return ans;
    }
}
