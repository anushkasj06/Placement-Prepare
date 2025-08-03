import java.util.*;

public class Search_Sorted_Rotated_Array_duplicate {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // Handle duplicates
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue; // Skip duplicates
            } else if (nums[left] <= nums[mid]) { // Left half is sorted
                if (nums[left] <= target && target <=nums[mid]) {
                    right = mid - 1; // Target in the left half
                } else {
                    left = mid + 1; // Target in the right half
                }
            } else { // Right half is sorted
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1; // Target in the right half
                } else {
                    right = mid - 1; // Target in the left half
                }
            }
        }
        
        return false; // Target not found
    }
}
